package butler.task;

import butler.util.LocalDateTimeManager;

public class Deadline extends Task {

    private String dateAndTime;
    private String localDateTime;

    public Deadline(String description, String dateAndTime) {
        super(description);
        this.dateAndTime = dateAndTime;
        localDateTime = LocalDateTimeManager.toLocalDateTime(dateAndTime);
    }

    public String getTaskType() {
        return "[D]";
    }

    @Override
    public String toString() {
        if (!localDateTime.equals("")) {
            return this.getTaskType() + super.toString() + " " + localDateTime;
        }
        return this.getTaskType() + super.toString() + " (by: " + dateAndTime + ")";
    }
}
