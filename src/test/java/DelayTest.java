import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class DelayTest extends BaseTest{

    @Test
    public void testDelay(){
        var delayPage = homePage.delayPage();
        delayPage.pressStart();
        assertTrue(delayPage.waitDelay());
    }

}
