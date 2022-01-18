public class Deadline extends Task{
    String dateAndTime;

    protected Deadline(String description, String dateAndTime) {
        super(description);
        this.dateAndTime = dateAndTime;
    }

    protected String getTaskType() {
        return "[D]";
    }

    @Override
    public String toString() {
        return this.getTaskType() + super.toString() + "(by: " + dateAndTime + ")";
    }
}
