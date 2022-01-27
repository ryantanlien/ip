package butler.util;

import butler.ButlerInputException;
import butler.command.*;

public class Parser {

    public static Command parse(String input) throws ButlerInputException {
        String[] stringArray = input.split(" ");
        String firstWord = stringArray[0];
        if (firstWord.equals("bye")) {
            return new ByeCommand();
        }
        else if (firstWord.equals("list") && stringArray.length == 1) {
            return new ListCommand();
        }
        else if (firstWord.equals("mark")) {
            if (stringArray.length != 2) {
                throw new ButlerInputException("Error. Sorry Master, " +
                        "but a mark or unmark command must be followed by one Integer.\n");
            }
            try {
                return new MarkCommand(Integer.parseInt(stringArray[1]) - 1);
            } catch (NumberFormatException exception) {
                throw new ButlerInputException("Error. Sorry Master, " +
                       "but a mark or unmark command must be followed by one Integer.\n");
            }
        }
        else if (firstWord.equals("unmark")) {
            if (stringArray.length != 2) {
                throw new ButlerInputException("Error. Sorry Master, " +
                        "but a mark or unmark command must be followed by one Integer.\n");
            }
            try {
                return new UnmarkCommand(Integer.parseInt(stringArray[1]) - 1);
            } catch (NumberFormatException exception) {
                throw new ButlerInputException("Error. Sorry Master, " +
                        "but a mark or unmark command must be followed by one Integer.\n");
            }
        }
        else if (firstWord.equals("todo")) {
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
        }
        else if (firstWord.equals("deadline")) {
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
        }
        else if (firstWord.equals("event")) {
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
        }
        else if (firstWord.equals("delete")) {
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
