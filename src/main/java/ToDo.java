public class ToDo extends Task{

    protected ToDo(String description) {
        super(description);
    }

    protected String getTaskType() {
        return "[T]";
    }

    @Override
    public String toString() {
        return this.getTaskType() + super.toString();
    }
}
