package luxcampus.com.server;

import java.io.IOException;

public class WebServer {

    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.setPort(3000);
        server.setPath("src/main/resources/webApp");
        server.start();
    }
}
