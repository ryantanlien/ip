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
            String[] stringArray = input.split(" ");
            String firstWord = stringArray[0];
            if (firstWord.equals("bye")) {
                System.out.println("Farewell Master. Glad to be of service.");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
                System.exit(0);
            }
            if (firstWord.equals("list") && stringArray.length == 1) {
                System.out.println(butler.viewList());
                continue;
            }
            if (input.contains("mark"))  {
                if (stringArray[0].equals("mark")) {
                    String message = butler.markAsDone(Integer.parseInt(stringArray[1]) - 1);
                    System.out.println(message);
                    continue;
                }
                if (stringArray[0].equals("unmark")) {
                    String message = butler.markAsUndone(Integer.parseInt(stringArray[1]) - 1);
                    System.out.println(message);
                    continue;
                }
            }
            if (firstWord.equals("deadline")) {
                StringBuilder description = new StringBuilder();
                String[] dStringArray = input.split(" /by ");
                String[] strArray1 = dStringArray[0].split(" ");
                for (int i = 1; i < strArray1.length; i++) {
                    if (i == strArray1.length - 1) {
                        description.append(strArray1[i]);
                    } else {
                        description.append(strArray1[i] + " ");
                    }
                }
                String message = butler.addDeadlineToList(description.toString(), dStringArray[1]);
                System.out.println(message);
                continue;
            }
            if (firstWord.equals("todo")) {
                StringBuilder description = new StringBuilder();
                String[] dStringArray = input.split(" /at ");
                String[] strArray1 = dStringArray[0].split(" ");
                for (int i = 1; i < strArray1.length; i++) {
                    if (i == strArray1.length - 1) {
                        description.append(strArray1[i]);
                    } else {
                        description.append(strArray1[i] + " ");
                    }
                }
                String message = butler.addToDoToList(description.toString());
                System.out.println(message);
                continue;
            }
            if (firstWord.equals("event")) {
                StringBuilder description = new StringBuilder();
                String[] dStringArray = input.split(" /at ");
                String[] strArray1 = dStringArray[0].split(" ");
                for (int i = 1; i < strArray1.length; i++) {
                    if (i == strArray1.length - 1) {
                        description.append(strArray1[i]);
                    } else {
                        description.append(strArray1[i] + " ");
                    }
                }
                String message = butler.addEventToList(description.toString(),dStringArray[1]);
                System.out.println(message);
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

    protected String addDeadlineToList(String description, String dateTime) {
        Task task = new Deadline(description, dateTime);
        tasks.add(task);
        return "Noted Master. I'll add this task to your list.\n" + "   " + task.toString() +
                "\nThere are now " + tasks.size() + " tasks in your list.\n";
    }

    protected String addToDoToList(String description) {
        Task task = new ToDo(description);
        tasks.add(task);
        return "Noted Master. I'll add this task to your list.\n" + "   " + task.toString() +
                "\nThere are now " + tasks.size() + " tasks in your list.\n";
    }

    protected String addEventToList(String description, String dateTime) {
        Task task = new Event(description, dateTime);
        tasks.add(task);
        return "Noted Master. I'll add this task to your list.\n" + "   " + task.toString() +
                "\nThere are now " + tasks.size() + " tasks in your list.\n";
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
        String output = "Here are the tasks in your list Master: \n";
        while (i < tasks.size()) {
            Task task = tasks.get(i);
            output += String.valueOf(i + 1) + ". " + task.toString() + "\n";
            i++;
        }
        return output;
    }
}