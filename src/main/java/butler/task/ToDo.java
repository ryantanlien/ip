package butler.task;

public class ToDo extends Task {

    public ToDo(String description) {
        super(description);
    }

    public String getTaskType() {
        return "[T]";
    }

    @Override
    public String toString() {
        return this.getTaskType() + super.toString();
    }
}
