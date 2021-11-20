package luxcampus.com.client;

import luxcampus.com.workwithuser.UserInput;

import java.io.*;
import java.net.Socket;
import java.util.Objects;

public class Client {

    public static void main(String[] args) throws IOException {
        UserInput userInput = new UserInput();
        while (true) {
            String message = userInput.getMessageFromUser();
            try (Socket socket = new Socket("localhost", 3000);
                 BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))
            ) {

                bufferedWriter.write(message);
                bufferedWriter.newLine();
                bufferedWriter.flush();

                String serverResponse = bufferedReader.readLine();
                System.out.println(serverResponse);
                if (Objects.equals(serverResponse, "Server Shutdown")) {
                    break;
                }

            }
        }
    }

}
