package butler.command;

import butler.ButlerInputException;
import butler.TaskList;
import butler.util.Storage;
import butler.util.Ui;

public class MarkCommand extends Command {

    /* Index of taskList that is to be marked */
    int index;

    /**
     * Constructs a MarkCommand object that executes a specified command.
     *
     * @param index Index of taskList that is to be marked.
     */
    public MarkCommand(int index) {
        this.index = index;
    }

    /**
     * Executes command behavior.
     * In this case it marks a task at a given index from the taskList and stores the update list in a file.
     * Then it prints a success message to output, else it prints a failure message.
     *
     * @param taskList A managed list of tasks.
     * @param storage A handler class that handles file I/O, storing taskList details in a file.
     * @param ui A handler class that handles user input and output.
     */
    @Override
    public void execute(TaskList taskList, Storage storage, Ui ui) {
        try {
            String message = taskList.markAsDone(index);
            storage.writeTaskListToFile(taskList);
            ui.printMessage(message);
        } catch (ButlerInputException exception) {
            ui.printMessage(exception.getMessage());
        }
    }
}
