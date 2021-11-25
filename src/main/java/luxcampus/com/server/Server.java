package luxcampus.com.server;

import luxcampus.com.requesthandle.RequestHandler;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static final int INITIAL_SERVER_PORT = 3000;
    int port = INITIAL_SERVER_PORT;
    String webAppPath;


    public void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)
        ) {
            while (true) {
                try (Socket socket = serverSocket.accept();
                     BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                     BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))
                ) {
                    RequestHandler requestHandler = new RequestHandler();
                    requestHandler.handle();

                }
            }
        }
    }


    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }


    public String getPath() {
        return webAppPath;
    }

    public void setPath(String webAppPath) {
        this.webAppPath = webAppPath;
    }
}