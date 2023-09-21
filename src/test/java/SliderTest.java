
import listeners.EventListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
@Listeners(EventListener.class)

public class SliderTest extends BaseTest{

    @Test
    public void testSlider(){
        int value = 13;
        var slider = homePage.sliderPage();
        slider.slide(value);

        assertEquals(slider.getValue(), value);


    }



}
