package luxcampus.com.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;

public class Server {
    private final static String EXIT_MESSAGE = "exit";

    public static void main(String[] args) throws IOException {
        while (true) {
            try (ServerSocket serverSocket = new ServerSocket(3000);
                 Socket socket = serverSocket.accept();
                 BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))
            ) {
                String clientMessage = bufferedReader.readLine();
                if (Objects.equals(clientMessage.toLowerCase(), EXIT_MESSAGE)) {
                    bufferedWriter.write("Server Shutdown");
                    bufferedWriter.flush();
                    break;
                }
                bufferedWriter.write("echo " + clientMessage);
                bufferedWriter.flush();

            }
        }
        System.out.println("server shutdown");
    }
}
