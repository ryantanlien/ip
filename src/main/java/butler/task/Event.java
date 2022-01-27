package butler.task;

import butler.util.LocalDateTimeManager;

public class Event extends Task {
    /* String representation of date and time not following any format */
    private String dateAndTime;
    /* String representation of formatted LocalDateTime objects */
    private String localDateTime;

    /**
     * Constructs an Event object that must be attended at a certain date and time.
     * If a date and time provided does not follow the dateFormatter provided, treats it as a string.
     *
     * @param dateAndTime string representation of date and time provided by user.
     * @param description description of the task.
     */
    public Event(String description, String dateAndTime) {
        super(description);
        this.dateAndTime = dateAndTime;
        localDateTime = LocalDateTimeManager.toLocalDateTime(dateAndTime);
    }

    /**
     * Returns symbolic representation of task type.
     *
     * @return String Representation of task type.
     */
    public String getTaskType() {
        return "[E]";
    }

    /**
     * Represents Event object as a String
     *
     * @return String Representation of task as a whole.
     */
    @Override
    public String toString() {
        if (!localDateTime.equals("")) {
            return this.getTaskType() + super.toString() + " " + localDateTime;
        }
        return this.getTaskType() + super.toString() + " (at: " + dateAndTime + ")";
    }
}

