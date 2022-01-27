public class Butler {

    public static void main(String[] args) {
        Butler butler = new Butler();
        String greetings = butler.greet();
        Ui ui = new Ui();
        Storage storage = new Storage("");
        TaskList taskList = new TaskList();
        ui.printMessage(greetings);

        while (true) {
            String input = ui.getInput();
            try {
                Command command = Parser.parse(input);
                command.execute(taskList, storage, ui);
            } catch (ButlerInputException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    public Butler() {
    }

    protected String greet() {
        return "Greetings! I'm Butler!\n" + "What can I do for you today Master?\n";
    }
}