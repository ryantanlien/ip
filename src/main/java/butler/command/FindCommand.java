package butler.command;

import butler.TaskList;
import butler.util.Storage;
import butler.util.ui.Ui;

public class FindCommand extends Command {
    private String searchString;

    public FindCommand(String searchString) {
        this.searchString = searchString;
    }

    @Override
    public void execute(TaskList taskList, Storage storage, Ui ui) {
        String message = taskList.find(searchString);
        ui.setMessage(message);
    }
}
