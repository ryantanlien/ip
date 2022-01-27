package butler.command;

import butler.ButlerInputException;
import butler.util.Storage;
import butler.TaskList;
import butler.util.Ui;

public class InvalidCommand extends Command {

    /**
     * Executes command behavior.
     * In this case it throws a ButlerInputException to be handled down the line.
     *
     * @param taskList A managed list of tasks.
     * @param storage A handler class that handles file I/O, storing taskList details in a file.
     * @param ui A handler class that handles user input and output.
     */
    @Override
    public void execute(TaskList taskList, Storage storage, Ui ui) throws ButlerInputException {
        throw new ButlerInputException("I'm sorry Master, but I do not know what that means. " +
                "Please provide a valid command.\n");

    }
}
