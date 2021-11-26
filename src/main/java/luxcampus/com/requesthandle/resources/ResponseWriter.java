package luxcampus.com.requesthandle.resources;

import java.io.BufferedWriter;
import java.io.IOException;

public class ResponseWriter {

    public void writeResponse(String content, BufferedWriter writer) throws IOException {
        String response = "HTTP/1.1";
        if (content != null){
            response = response.concat(StatusCodes.OK.getStatusText());
            writer.write(response);
            writer.newLine();
            writer.write(content);
        }
        response = response.concat(StatusCodes.NOT_FOUND.getStatusText());
        writer.write(response);
        writer.newLine();
    }

}
