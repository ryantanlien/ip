package butler.util;

import butler.ButlerInputException;
import butler.command.ByeCommand;
import butler.command.Command;
import butler.command.DeadlineCommand;
import butler.command.DeleteCommand;
import butler.command.EventCommand;
import butler.command.FindCommand;
import butler.command.InvalidCommand;
import butler.command.ListCommand;
import butler.command.MarkCommand;
import butler.command.TodoCommand;
import butler.command.UnmarkCommand;

public class Parser {

    /**
     * Parses user input and check if it matches any predefined commands.
     * Predefined commands are:
     * bye
     * list
     * mark
     * unmark
     * todo
     * deadline
     * event
     * find
     * delete
     *
     * @param input User input.
     * @return Command Relevant command to execute given the input.
     * @throws ButlerInputException This exception is thrown via the InvalidCommand if input matches no given commands.
     */
    public static Command parse(String input) throws ButlerInputException {
        String[] stringArray = input.split(" ");
        String firstWord = stringArray[0];
        if (firstWord.equals("bye")) {
            return new ByeCommand();
        } else if (firstWord.equals("list") && stringArray.length == 1) {
            return new ListCommand();
        } else if (firstWord.equals("mark")) {
            if (stringArray.length != 2) {
                throw new ButlerInputException("Error. Sorry Master, "
                        + "but a mark or unmark command must be followed by one Integer.\n");
            }
            try {
                return new MarkCommand(Integer.parseInt(stringArray[1]) - 1);
            } catch (NumberFormatException exception) {
                throw new ButlerInputException("Error. Sorry Master, "
                        + "but a mark or unmark command must be followed by one Integer.\n");
            }
        } else if (firstWord.equals("unmark")) {
            if (stringArray.length != 2) {
                throw new ButlerInputException("Error. Sorry Master, "
                        + "but a mark or unmark command must be followed by one Integer.\n");
            }
            try {
                return new UnmarkCommand(Integer.parseInt(stringArray[1]) - 1);
            } catch (NumberFormatException exception) {
                throw new ButlerInputException("Error. Sorry Master, " +
                        "but a mark or unmark command must be followed by one Integer.\n");
            }
        } else if (firstWord.equals("todo")) {
            StringBuilder description = new StringBuilder();
            String[] dStringArray = input.split(" /at ");
            String[] strArray = dStringArray[0].split(" ");
            for (int i = 1; i < strArray.length; i++) {
                if (i == strArray.length - 1) {
                    description.append(strArray[i]);
                } else {
                    description.append(strArray[i] + " ");
                }
            }
            return new TodoCommand(description.toString());
        } else if (firstWord.equals("deadline")) {
            StringBuilder description = new StringBuilder();
            StringBuilder dateTime = new StringBuilder();
            String[] dStringArray = input.split(" /by ");
            String[] strArray = dStringArray[0].split(" ");
            for (int i = 1; i < strArray.length; i++) {
                if (i == strArray.length - 1) {
                    description.append(strArray[i]);
                } else {
                    description.append(strArray[i] + " ");
                }
            }
            if (dStringArray.length == 2) {
                dateTime.append(dStringArray[1]);
            }
            return new DeadlineCommand(description.toString(), dateTime.toString());
        } else if (firstWord.equals("event")) {
            StringBuilder description = new StringBuilder();
            StringBuilder dateTime = new StringBuilder();
            String[] dStringArray = input.split(" /at ");
            String[] strArray = dStringArray[0].split(" ");
            for (int i = 1; i < strArray.length; i++) {
                if (i == strArray.length - 1) {
                    description.append(strArray[i]);
                } else {
                    description.append(strArray[i] + " ");
                }
            }
            if (dStringArray.length == 2) {
                dateTime.append(dStringArray[1]);
            }
            return new EventCommand(description.toString(), dateTime.toString());
        } else if (firstWord.equals("find")) {
            if (stringArray.length < 2) {
                throw new ButlerInputException("Error. Sorry Master, " +
                        "but a find command must be followed by a description.\n");
            }
            StringBuilder description = new StringBuilder();
            for (int i = 1; i < stringArray.length; i++) {
                if (i == stringArray.length - 1) {
                    description.append(stringArray[i]);
                } else {
                    description.append(stringArray[i] + " ");
                }
            }
            return new FindCommand(description.toString());
        } else if (firstWord.equals("delete")) {
            if (stringArray.length != 2) {
                throw new ButlerInputException("Error. Sorry Master, " +
                        "but a delete command must only be followed by one Integer.\n");
            }
            try {
                return new DeleteCommand(Integer.parseInt(stringArray[1]) - 1);
            } catch (NumberFormatException exception) {
                throw new ButlerInputException("Error. Sorry Master, " +
                        "but a delete command must only be followed by one Integer.\n");
            }
        } else {
            return new InvalidCommand();
        }
    }
}
