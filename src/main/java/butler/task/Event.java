package butler.task;

import butler.util.LocalDateTimeManager;

public class Event extends Task {
    private String dateAndTime;
    private String localDateTime;

    public Event(String description, String dateAndTime) {
        super(description);
        this.dateAndTime = dateAndTime;
        localDateTime = LocalDateTimeManager.toLocalDateTime(dateAndTime);
    }

    public String getTaskType() {
        return "[E]";
    }

    @Override
    public String toString() {
        if (!localDateTime.equals("")) {
            return this.getTaskType() + super.toString() + " " + localDateTime;
        }
        return this.getTaskType() + super.toString() + " (at: " + dateAndTime + ")";
    }
}

