public class Task {
    protected String description;
    protected boolean isDone;

    protected Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    protected String getStatusIcon() {
        return (this.isDone ? "X" : " ");
    }

    protected boolean markAsDone() {
        this.isDone = true;
        return isDone;
    }

    protected boolean markAsUndone() {
        this.isDone = false;
        return this.isDone;
    }

    @Override
    public String toString() {
        return "[" + this.getStatusIcon() + "] " +
                this.description;
    }
}