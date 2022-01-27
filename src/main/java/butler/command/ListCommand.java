package butler.command;

import butler.TaskList;
import butler.util.Storage;
import butler.util.Ui;

public class ListCommand extends Command {
    @Override
    public void execute(TaskList taskList, Storage storage, Ui ui) {
        ui.printMessage(taskList.viewList());
    }
}
