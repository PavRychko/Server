package luxcampus.com.workwithuser;

import java.util.Scanner;

public class UserInput {
    public String getMessageFromUser() {
        Scanner scanner = new Scanner(System.in);
        String userMessage = scanner.nextLine();
        return userMessage;
    }


}
