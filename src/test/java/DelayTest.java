import listeners.EventListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

@Listeners(EventListener.class)
public class DelayTest extends BaseTest{

    @Test
    public void testDelay(){
        var delayPage = homePage.delayPage();
        delayPage.pressStart();
        assertTrue(delayPage.waitDelay());
    }

}
