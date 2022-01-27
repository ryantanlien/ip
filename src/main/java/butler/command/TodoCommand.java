package butler.command;

import butler.ButlerInputException;
import butler.util.Storage;
import butler.TaskList;
import butler.util.Ui;

public class TodoCommand extends Command {

    /* Description of what needs to be done for the task */
    String description;

    /**
     * Constructs a TodoCommand object that executes a specified command.
     *
     * @param description description of the task.
     */
    public TodoCommand(String description) {
        this.description = description;
    }

    /**
     * Executes command behavior.
     * In this case it adds ToDo to the taskList and stores the updated list in a file.
     * Then it prints a success message to output, else it prints a failure message.
     *
     * @param taskList A managed list of tasks.
     * @param storage A handler class that handles file I/O, storing taskList details in a file.
     * @param ui A handler class that handles user input and output.
     */
    @Override
    public void execute(TaskList taskList, Storage storage, Ui ui) {
        try {
            String message = taskList.addToDoToList(description);
            storage.writeTaskListToFile(taskList);
            ui.printMessage(message);
        } catch (ButlerInputException exception) {
            ui.printError(exception.getMessage());
        }
    }
}
