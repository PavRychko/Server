package luxcampus.com.server;

public class WebServer {

    public static void main(String[] args) {
        Server server = new Server();
        server.setPort(3000);
        server.setPath("src/main/resources/webApp");
//        server.start();
    }
}
