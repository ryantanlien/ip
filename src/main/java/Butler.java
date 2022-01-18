import java.util.ArrayList;
import java.util.Scanner;

public class Butler {

    ArrayList<Task> tasks;

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
            if (input.contains("mark"))  {
                String[] stringArray = input.split(" ");
                if (stringArray[0].equals("mark")) {
                    String message = butler.markAsDone(Integer.parseInt(stringArray[1]) - 1);
                    System.out.println(message);
                }
                if (stringArray[0].equals("unmark")) {
                    String message = butler.markAsUndone(Integer.parseInt(stringArray[1]) - 1);
                    System.out.println(message);
                }
                continue;
            }
            System.out.println(butler.addToList(input));
        }
    }

    public Butler() {
        tasks = new ArrayList<>();
    }

    protected String greet() {
        return "Greetings! I'm Butler!\n" + "What can I do for you today Master?\n";
    }

    protected String addToList(String string) {
        Task task = new Task(string);
        tasks.add(task);
        return "added: " + string;
    }

    protected String markAsDone(int index) {
        Task task = tasks.get(index);
        task.markAsDone();
        String string = "Congratulations Master, I've marked this task as done: \n";
        return string + "   [" + task.getStatusIcon() + "] " + task.description + "\n";
    }

    protected String markAsUndone(int index) {
        Task task = tasks.get(index);
        task.markAsUndone();
        String string = "Very well Master, I've marked this task as not done yet: \n";
        return string + "   [" + task.getStatusIcon() + "] " + task.description + "\n";
    }


    protected String viewList() {
        int i = 0;
        String output = "Here are the tasks in your list master: \n";
        while (i < tasks.size()) {
            Task task = tasks.get(i);
            output += String.valueOf(i + 1) + ". " + "[" + task.getStatusIcon() + "] " +
                    task.description + "\n";
            i++;
        }
        return output;
    }
}