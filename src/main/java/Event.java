public class Event extends Task {
    String dateAndTime;
    String localDateTime;

    protected Event(String description, String dateAndTime) {
        super(description);
        this.dateAndTime = dateAndTime;
        localDateTime = LocalDateTimeManager.toLocalDateTime(dateAndTime);
    }

    protected String getTaskType() {
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

