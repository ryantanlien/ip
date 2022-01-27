public class Deadline extends Task{
    String dateAndTime;
    String localDateTime;

    protected Deadline(String description, String dateAndTime) {
        super(description);
        this.dateAndTime = dateAndTime;
        localDateTime = LocalDateTimeManager.toLocalDateTime(dateAndTime);
    }

    protected String getTaskType() {
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
