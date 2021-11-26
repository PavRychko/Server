package luxcampus.com.requesthandle.resources;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;


public class RequestParser {


    public Request parse(BufferedReader requestReader) throws IOException {
        Request request = new Request();
        String firstLine = requestReader.readLine();
        injectUriAndMethod(firstLine, request);

        String header;
        while ((header = requestReader.readLine()) != null) {
            injectHeaders(header, request);
        }

        return request;
    }


    private void injectUriAndMethod(String line, Request request) {
        String[] split = line.split(" ");
        request.setMethod(HttpMethod.valueOf(split[0]));
        request.setUri(split[1]);
    }

    private void injectHeaders(String line, Request request) {
        Map<String, String> headers = request.getHeaders();
        String[] splitHeaderLines = line.split(" ", 2);
        headers.put(splitHeaderLines[0], splitHeaderLines[1]);
//        request.setHeaders(headers);
    }

}
