package butler.util;

import java.util.Scanner;

public class Ui {

    static Scanner scanner = new Scanner(System.in);

    /**
     * Gets input from the Scanner object line by line.
     *
     * @return String User input in the next line as a String.
     */
    public String getInput() {
        return scanner.nextLine();
    }

    /**
     * Prints a message.
     *
     */
    public void printMessage(String message) {
        System.out.println(message);
    }

    /**
     * Prints an error message.
     *
     */
    public void printError(String errorMessage) {
        System.out.println(errorMessage);
    }
}
