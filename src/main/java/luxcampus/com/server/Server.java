package luxcampus.com.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;

public class Server {
    private final static String EXIT_MESSAGE = "exit";
    int port;
    String Path;

    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(3000)
        ) {
            while (true) {
                try (Socket socket = serverSocket.accept();
                     BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                     BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))
                ) {

                    String clientMessage = bufferedReader.readLine();
                    if (Objects.equals(clientMessage.toLowerCase(), EXIT_MESSAGE)) {
                        bufferedWriter.write("Server Shutdown");
                        break;
                    }
                    bufferedWriter.write("echo " + clientMessage);

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
        return Path;
    }

    public void setPath(String path) {
        Path = path;
    }
}
