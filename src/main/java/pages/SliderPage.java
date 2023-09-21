package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderPage extends BasePage{
    public SliderPage(WebDriver driver) {
        super(driver);
    }


    public void slide(int value){
        var actions = new Actions(driver);
        clickSlider();
        int i = 50;
        while (i != value){
            if(i<value){
                i++;
                actions.keyDown(Keys.ARROW_RIGHT);
            } else {
                i--;
                actions.keyDown(Keys.ARROW_LEFT);
            }
        }



        actions.perform();

    }

    public int getValue(){
        return Integer.parseInt(findById("value").getText());
    }

    public void clickSlider(){
        findById("slideMe").click();
    }




}
