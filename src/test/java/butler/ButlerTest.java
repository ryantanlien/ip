package butler;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class ButlerTest {
    @Test
    public void butlerGreeting_returnGreeting() {
        Butler butler = new Butler();
        Assertions.assertEquals("Greetings! I'm Butler!\n" + "What can I do for you today Master?\n",
                butler.greet());
    }
}
