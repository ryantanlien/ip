package butler;

import butler.task.Deadline;
import butler.task.Event;
import butler.task.Task;
import butler.task.ToDo;

import java.util.ArrayList;

public class TaskList {

    protected ArrayList<Task> tasks;

    public TaskList() {
        tasks = new ArrayList<>();
    }

    public Task get(int index) {
        return tasks.get(index);
    }

    public int size() {
        return tasks.size();
    }

    public String find(String searchString) {
        int i = 0;
        String output = "Here are the matching tasks in your list, Master: \n";
        while (i < tasks.size()) {
            Task task = tasks.get(i);
            if (task.getDescription().contains(searchString)) {
                output += String.valueOf(i + 1) + ". " + task.toString() + "\n";
            }
            i++;
        }
        return output;
    }

    public String addDeadlineToList(String description, String dateTime) throws ButlerInputException {
        if (description.equals("")) {
            throw new ButlerInputException("Error. Sorry Master, but the description of a butler.task.Deadline cannot be empty.\n");
        }
        if (dateTime.equals("")) {
            throw new ButlerInputException("Error. Sorry Master, but the date/time of a butler.task.Deadline cannot be empty.\n");
        }
        Task task = new Deadline(description, dateTime);
        tasks.add(task);
        return "Noted Master. I'll add this task to your list.\n" + "   " + task.toString() +
                "\nThere are now " + tasks.size() + " tasks in your list.\n";
    }

    public String addToDoToList(String description) throws ButlerInputException {
        if (description.equals("")) {
            throw new ButlerInputException("Error. Sorry Master, but the description of a butler.task.ToDo cannot be empty.\n");
        }
        Task task = new ToDo(description);
        tasks.add(task);
        return "Noted Master. I'll add this task to your list.\n" + "   " + task.toString() +
                "\nThere are now " + tasks.size() + " tasks in your list.\n";
    }

    public String addEventToList(String description, String dateTime) throws ButlerInputException {
        if (description.equals("")) {
            throw new ButlerInputException("Error. Sorry Master, but the description of an butler.task.Event cannot be empty.\n");
        }
        if (dateTime.equals("")) {
            throw new ButlerInputException("Error. Sorry Master, but the date/time of an butler.task.Event cannot be empty.\n");
        }
        Task task = new Event(description, dateTime);
        tasks.add(task);
        return "Noted Master. I'll add this task to your list.\n" + "   " + task.toString() +
                "\nThere are now " + tasks.size() + " tasks in your list.\n";
    }

    public String deleteTaskFromList(int index) throws ButlerInputException {
        if (index >= tasks.size()) {
            throw new ButlerInputException("Error. Master list item number "
                    + String.valueOf(index + 1) + "does not exist. \n");
        }
        Task task = tasks.remove(index);
        return "Noted Master. I'll remove this task from your list.\n" + "   " + task.toString() +
                "\n There are now " + tasks.size() + " tasks in your list.\n";
    }

    public String markAsDone(int index) throws ButlerInputException {
        if (index >= tasks.size()) {
            throw new ButlerInputException("Error. Master, list item number "
                    + String.valueOf(index + 1) + " does not exist.\n");
        }
        Task task = tasks.get(index);
        task.markAsDone();
        String string = "Congratulations Master, I've marked this task as done: \n";
        return string + "   [" + task.getStatusIcon() + "] " + task.getDescription() + "\n";
    }

    public String markAsUndone(int index) throws ButlerInputException {
        if (index >= tasks.size()) {
            throw new ButlerInputException("Error. Master, list item number "
                    + String.valueOf(index + 1) + " does not exist.\n");
        }
        Task task = tasks.get(index);
        task.markAsUndone();
        String string = "Very well Master, I've marked this task as not done yet: \n";
        return string + "   [" + task.getStatusIcon() + "] " + task.getDescription() + "\n";
    }

    public String viewList() {
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
