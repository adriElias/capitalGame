package org.capitalGame;
import java.util.Scanner;

public class KeyboardReader {
    private static final Scanner scanner = new Scanner(System.in);

    public static String readString(String message) {
        while (true) {
            System.out.print(message);
            try {
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    throw new InvalidInputException("Input cannot be empty.");
                }
                return input;
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage() + " Please try again.");
            }
        }
    }

    public static String readLettersOnly(String message) {
        while (true) {
            String input = readString(message);
            try {
                if (!input.matches("[a-zA-ZÀ-ÿ ]+")) {
                    throw new InvalidInputException("Input must contain letters only.");
                }
                return input;
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage() + " Please try again.");
            }
        }
    }

    public static void close() {
        scanner.close();
    }
}
