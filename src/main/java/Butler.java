import java.util.ArrayList;
import java.util.Scanner;

public class Butler {

    ArrayList<String> arrayList;

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
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
                System.exit(0);
            }
            if (input.equals("list")) {
                System.out.println(butler.viewList());
                continue;
            }
            System.out.println(butler.addToList(input));
        }
    }

    public Butler() {
        arrayList = new ArrayList<>();
    }

    public String greet() {
        return "Greetings! I'm Butler!\n" + "What can I do for you today Master?\n";
    }

    public String addToList(String string) {
        arrayList.add(string);
        return "added: " + string;
    }

    public String viewList() {
        int i = 0;
        String output = "";
        while (i < arrayList.size()) {
            output += String.valueOf(i + 1) + ". " + arrayList.get(i) + "\n";
            i++;
        }
        return output;
    }
}