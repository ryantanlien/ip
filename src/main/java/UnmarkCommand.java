public class UnmarkCommand extends Command{

    int index;

    public UnmarkCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList taskList, Storage storage, Ui ui) throws ButlerInputException {
        try {
            String message = taskList.markAsUndone(index);
            storage.writeTaskListToFile(taskList);
            ui.printMessage(message);
        } catch (NumberFormatException exception) {
            ui.printError("Error. Sorry Master, " +
                    "but a mark or unmark command must be followed by one Integer.\n");
        }
    }
}
