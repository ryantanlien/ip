import java.util.Scanner;

public class Ui {

    static Scanner scanner = new Scanner(System.in);

    public String getInput() {
        return scanner.nextLine();
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printError(String errorMessage) {
        System.out.println(errorMessage);
    }
}
