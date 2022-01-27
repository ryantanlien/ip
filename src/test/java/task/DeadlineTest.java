package task;

import butler.task.Deadline;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class DeadlineTest {
    @Test
    public void deadlineGetTaskType_returnTaskTypeString() {
        Deadline deadline = new Deadline("hello", "Sat 4pm");
        Assertions.assertEquals("[D]",deadline.getTaskType());
    }
}
