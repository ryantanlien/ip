public class DeleteCommand extends Command {

    int index;

    public DeleteCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList taskList, Storage storage, Ui ui) throws ButlerInputException {
        try {
            String message = taskList.deleteTaskFromList(index);
            storage.writeTaskListToFile(taskList);
            ui.printMessage(message);
        } catch (ButlerInputException exception) {
            ui.printError(exception.getMessage());
        }
    }
}
