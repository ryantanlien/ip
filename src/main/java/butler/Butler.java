package butler;

import butler.command.Command;
import butler.util.Parser;
import butler.util.Storage;
import butler.util.ui.Ui;
import butler.util.ui.UiApp;
import javafx.application.Application;

public class Butler {

    private static Storage storage = new Storage("");
    private static Ui ui = Ui.getUi();
    private static TaskList taskList = new TaskList();

    public Butler() {
    }

    public static void main(String[] args) {
        Application.launch(UiApp.class, args);
    }

    public static String respond(String input) {
        try {
            checkInstantiated();
            Command command = Parser.parse(input);
            command.execute(taskList, storage, ui);
            return ui.getMessage();
        } catch (ButlerInputException exception) {
            return exception.getMessage();
        }
    }

    public static void checkInstantiated() {
        assert storage != null;
        assert ui != null;
        assert taskList != null;
    }

    public static String greet() {
        return "Greetings! I'm Butler!\n" + "What can I do for you today Master?\n";
    }
}
