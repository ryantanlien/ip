import java.util.ArrayList;
import java.util.Scanner;

public class Butler {
    public static void main(String[] args) {
        Butler butler = new Butler();
        String greetings = butler.greet();
        System.out.println(greetings);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("bye")) {
                System.out.println("Farewell Master. Glad to be of service.");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException exception){
                    exception.printStackTrace();
                }
                System.exit(0);
            }
            System.out.println(input);
        }
    }

    public Butler() {
    }

    public String greet() {
        return "Greetings! I'm Butler!\n" + "What can I do for you today Master?\n";
    }
}
