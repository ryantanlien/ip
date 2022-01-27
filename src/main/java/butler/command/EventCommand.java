package butler.command;

import butler.ButlerInputException;
import butler.util.Storage;
import butler.TaskList;
import butler.util.Ui;

public class EventCommand extends Command{
    private String description;
    private String dateTime;

    public EventCommand(String description, String dateTime) {
        this.description = description;
        this.dateTime = dateTime;
    }

    @Override
    public void execute(TaskList taskList, Storage storage, Ui ui) throws ButlerInputException {
        try {
            String message = taskList.addEventToList(description, dateTime);
            storage.writeTaskListToFile(taskList);
            ui.printMessage(message);
        } catch (ButlerInputException exception) {
            ui.printError(exception.getMessage());
        }

    }
}
