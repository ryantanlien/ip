package butler.command;

import butler.util.Storage;
import butler.TaskList;
import butler.util.Ui;

public class ByeCommand extends Command{

    @Override
    public void execute(TaskList taskList, Storage storage, Ui ui) {
        ui.printMessage("Farewell Master. Glad to be of service.");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        System.exit(0);
    }
}
