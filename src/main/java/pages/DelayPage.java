package pages;

import org.openqa.selenium.WebDriver;

public class DelayPage extends BasePage{
    public DelayPage(WebDriver driver) {
        super(driver);
    }

    public void pressStart(){
        click(findById("start"));
    }
    public Boolean waitDelay(){
        return attributeToBe(findById("delay"), "value", "Liftoff!");
    }
}
