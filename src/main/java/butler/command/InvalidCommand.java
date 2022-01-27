package butler.command;

import butler.ButlerInputException;
import butler.TaskList;
import butler.util.Storage;
import butler.util.Ui;

public class InvalidCommand extends Command {
    @Override
    public void execute(TaskList taskList, Storage storage, Ui ui) throws ButlerInputException {
        throw new ButlerInputException("I'm sorry Master, but I do not know what that means. " +
                "Please provide a valid command.\n");

    }
}
