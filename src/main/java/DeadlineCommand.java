public class DeadlineCommand extends Command {

    private String description;
    private String dateTime;

    public DeadlineCommand(String description, String dateTime) {
        this.description = description;
        this.dateTime = dateTime;
    }

    @Override
    public void execute(TaskList taskList, Storage storage, Ui ui) {
        try {
            String message = taskList.addDeadlineToList(description, dateTime);
            storage.writeTaskListToFile(taskList);
            ui.printMessage(message);
        } catch (ButlerInputException exception) {
            ui.printError(exception.getMessage());
        }
    }
}
