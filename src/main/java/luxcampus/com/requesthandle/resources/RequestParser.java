package luxcampus.com.requesthandle.resources;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class RequestParser {


    public Request parse(BufferedReader requestReader) throws IOException {
        Request request = new Request();
        String firstLine = requestReader.readLine();
        injectUriAndMethod(firstLine, request);
        String headerLines = requestReader.lines().collect(Collectors.joining()); // прибирає всі \n
        injectHeaders(headerLines, request);
        return request;
    }


    private void injectUriAndMethod(String line, Request request) {
        String[] split = line.split(" ");
        request.setMethod(HttpMethod.valueOf(split[0]));
        request.setUri(split[1]);
    }

    private void injectHeaders(String line, Request request) {
        Map<String, String> headers = new HashMap<>();
        String[] splitHeaders = line.split("\n");
        for (int i = 0; i < splitHeaders.length; i++) {
            String[] splitHeaderLines = splitHeaders[i].split(": ", 1);
            headers.put(splitHeaderLines[0], splitHeaderLines[1]);
        }
        request.setHeaders(headers);
    }
}
