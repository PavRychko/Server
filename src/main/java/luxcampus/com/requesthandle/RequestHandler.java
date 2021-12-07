package luxcampus.com.requesthandle;

import luxcampus.com.requesthandle.resources.Request;
import luxcampus.com.requesthandle.resources.RequestParser;
import luxcampus.com.requesthandle.resources.ResourceReader;
import luxcampus.com.requesthandle.resources.ResponseWriter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class RequestHandler {
    BufferedReader socketReader;
    BufferedWriter socketWriter;
    String webAppPath;


    public RequestHandler(BufferedReader socketReader, BufferedWriter socketWriter, String webAppPath) {
        this.socketReader = socketReader;
        this.socketWriter = socketWriter;
        this.webAppPath = webAppPath;
    }

    public void handle() throws IOException {
        RequestParser requestParser = new RequestParser();
        Request request = requestParser.parse(socketReader);
        ResourceReader resourceReader = new ResourceReader(webAppPath);
        String resource = resourceReader.readResource(request.getUri());
        ResponseWriter responseWriter = new ResponseWriter();
        responseWriter.writeResponse(resource, socketWriter);
    }
}
