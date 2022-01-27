package butler.command;

import butler.ButlerInputException;
import butler.util.Storage;
import butler.TaskList;
import butler.util.Ui;

public abstract class Command {
    public abstract void execute(TaskList taskList, Storage storage, Ui ui) throws ButlerInputException;
}
