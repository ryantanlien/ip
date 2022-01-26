import java.util.ArrayList;
import java.util.Scanner;

public class Butler {

    ArrayList<Task> tasks;

    public static void main(String[] args) {
        Butler butler = new Butler();
        butler.test();
        String greetings = butler.greet();
        System.out.println(greetings);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();
            try {
                butler.handleCommands(input);
            } catch (ButlerInputException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    public Butler() {
        tasks = new ArrayList<>();
    }
    
    protected String greet() {
        return "Greetings! I'm Butler!\n" + "What can I do for you today Master?\n";
    }

    protected String addDeadlineToList(String description, String dateTime) throws ButlerInputException {
        if (description.equals("")) {
            throw new ButlerInputException("Error. Sorry Master, but the description of a Deadline cannot be empty.\n");
        }
        if (dateTime.equals("")) {
            throw new ButlerInputException("Error. Sorry Master, but the date/time of a Deadline cannot be empty.\n");
        }
        Task task = new Deadline(description, dateTime);
        tasks.add(task);
        FileManager.writeTaskListToFile(tasks);
        return "Noted Master. I'll add this task to your list.\n" + "   " + task.toString() +
                "\nThere are now " + tasks.size() + " tasks in your list.\n";
    }

    protected String addToDoToList(String description) throws ButlerInputException {
        if (description.equals("")) {
            throw new ButlerInputException("Error. Sorry Master, but the description of a ToDo cannot be empty.\n");
        }
        Task task = new ToDo(description);
        tasks.add(task);
        FileManager.writeTaskListToFile(tasks);
        return "Noted Master. I'll add this task to your list.\n" + "   " + task.toString() +
                "\nThere are now " + tasks.size() + " tasks in your list.\n";
    }

    protected String addEventToList(String description, String dateTime) throws ButlerInputException {
        if (description.equals("")) {
            throw new ButlerInputException("Error. Sorry Master, but the description of an Event cannot be empty.\n");
        }
        if (dateTime.equals("")) {
            throw new ButlerInputException("Error. Sorry Master, but the date/time of an Event cannot be empty.\n");
        }
        Task task = new Event(description, dateTime);
        tasks.add(task);
        FileManager.writeTaskListToFile(tasks);
        return "Noted Master. I'll add this task to your list.\n" + "   " + task.toString() +
                "\nThere are now " + tasks.size() + " tasks in your list.\n";
    }

    protected String deleteTaskFromList(int index) throws ButlerInputException {
        if (index >= tasks.size()) {
            throw new ButlerInputException("Error. Master list item number "
                    + String.valueOf(index + 1) + "does not exist. \n");
        }
        Task task = tasks.remove(index);
        FileManager.writeTaskListToFile(tasks);
        return "Noted Master. I'll remove this task from your list.\n" + "   " + task.toString() +
                "\n There are now " + tasks.size() + " tasks in your list.\n";
    }

    protected String markAsDone(int index) throws ButlerInputException {
        if (index >= tasks.size()) {
            throw new ButlerInputException("Error. Master, list item number "
                    + String.valueOf(index + 1) + " does not exist.\n");
        }
        Task task = tasks.get(index);
        task.markAsDone();
        FileManager.writeTaskListToFile(tasks);
        String string = "Congratulations Master, I've marked this task as done: \n";
        return string + "   [" + task.getStatusIcon() + "] " + task.description + "\n";
    }

    protected String markAsUndone(int index) throws ButlerInputException {
        if (index >= tasks.size()) {
            throw new ButlerInputException("Error. Master, list item number "
                    + String.valueOf(index + 1) + " does not exist.\n");
        }
        Task task = tasks.get(index);
        task.markAsUndone();
        FileManager.writeTaskListToFile(tasks);
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

    protected void handleCommands(String input) throws ButlerInputException { //convert to switch statement
        Command command = Command.INVALID;
        String[] stringArray = input.split(" ");
        String firstWord = stringArray[0];
        if (firstWord.equals("bye")) {
            command = Command.BYE;
        }
        if (firstWord.equals("list") && stringArray.length == 1) {
            command = Command.LIST;
        }
        if (firstWord.equals("mark")) {
            command = Command.MARK;
        }
        if (firstWord.equals("unmark")) {
            command = Command.UNMARK;
        }
        if (firstWord.equals("deadline")) {
            command = Command.DEADLINE;
        }
        if (firstWord.equals("todo")) {
            command = Command.TODO;
        }
        if (firstWord.equals("event")) {
            command = Command.EVENT;
        }
        if (firstWord.equals("delete")) {
            command = Command.DELETE;
        }
        switch (command) {
            case BYE:
                System.out.println("Farewell Master. Glad to be of service.");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
                System.exit(0);
                break;
            case LIST:
                System.out.println(this.viewList());
                break;
            case MARK:
                if (stringArray.length != 2) {
                    throw new ButlerInputException("Error. Sorry Master, " +
                            "but a mark or unmark command must be followed by one Integer.\n");
                }
                try {
                    String message = this.markAsDone(Integer.parseInt(stringArray[1]) - 1);
                    System.out.println(message);
                } catch (NumberFormatException exception) {
                    System.out.println("Error. Sorry Master, " +
                            "but a mark or unmark command must be followed by one Integer.\n");
                }
                break;
            case UNMARK:
                if (stringArray.length != 2) {
                    throw new ButlerInputException("Error. Sorry Master, " +
                            "but a mark or unmark command must be followed by one Integer.\n");
                }
                try {
                    String message = this.markAsUndone(Integer.parseInt(stringArray[1]) - 1);
                    System.out.println(message);
                } catch (NumberFormatException exception) {
                    System.out.println("Error. Sorry Master, " +
                            "but a mark or unmark command must be followed by one Integer.\n");
                }
                break;
            case DEADLINE:
                StringBuilder description = new StringBuilder();
                StringBuilder dateTime = new StringBuilder();
                String[] dStringArray = input.split(" /by ");
                String[] strArray1 = dStringArray[0].split(" ");
                for (int i = 1; i < strArray1.length; i++) {
                    if (i == strArray1.length - 1) {
                        description.append(strArray1[i]);
                    } else {
                        description.append(strArray1[i] + " ");
                    }
                }
                if (dStringArray.length == 2) {
                    dateTime.append(dStringArray[1]);
                }
                try {
                    String message = this.addDeadlineToList(description.toString(), dateTime.toString());
                    System.out.println(message);
                } catch (ButlerInputException exception) {
                    System.out.println(exception.getMessage());
                }
                break;
            case TODO:
                StringBuilder description1 = new StringBuilder();
                String[] dStringArray1 = input.split(" /at ");
                String[] strArray2 = dStringArray1[0].split(" ");
                for (int i = 1; i < strArray2.length; i++) {
                    if (i == strArray2.length - 1) {
                        description1.append(strArray2[i]);
                    } else {
                        description1.append(strArray2[i] + " ");
                    }
                }
                try {
                    String message = this.addToDoToList(description1.toString());
                    System.out.println(message);
                } catch (ButlerInputException exception) {
                    System.out.println(exception.getMessage());
                }
                break;
            case EVENT:
                StringBuilder description2 = new StringBuilder();
                StringBuilder dateTime1 = new StringBuilder();
                String[] dStringArray2 = input.split(" /at ");
                String[] strArray3 = dStringArray2[0].split(" ");
                for (int i = 1; i < strArray3.length; i++) {
                    if (i == strArray3.length - 1) {
                        description2.append(strArray3[i]);
                    } else {
                        description2.append(strArray3[i] + " ");
                    }
                }
                if (dStringArray2.length == 2) {
                    dateTime1.append(dStringArray2[1]);
                }
                try {
                    String message = this.addEventToList(description2.toString(), dateTime1.toString());
                    System.out.println(message);
                } catch (ButlerInputException exception) {
                    System.out.println(exception.getMessage());
                }
                break;
            case DELETE:
                if (stringArray.length != 2) {
                    throw new ButlerInputException("Error. Sorry Master, " +
                            "but a delete command must only be followed by one Integer.\n");
                }
                try {
                    String message = this.deleteTaskFromList(Integer.parseInt(stringArray[1]) - 1);
                    System.out.println(message);
                } catch (NumberFormatException exception) {
                    System.out.println("Error. Sorry Master, " +
                            "but a delete command must only be followed by one Integer.\n");
                }
                break;
            case INVALID:
                throw new ButlerInputException("I'm sorry Master, but I do not know what that means. " +
                        "Please provide a valid command.\n");

        }
    }
}