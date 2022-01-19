public class Event extends Task {
    String dateAndTime;

    protected Event(String description, String dateAndTime) {
        super(description);
        this.dateAndTime = dateAndTime;
    }

    protected String getTaskType() {
        return "[E]";
    }

    @Override
    public String toString() {
        return this.getTaskType() + super.toString() + " (at: " + dateAndTime + ")";
    }
}

