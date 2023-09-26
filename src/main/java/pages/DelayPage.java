package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DelayPage extends BasePage{

    private By startButton = By.id("start");
    private By delayMessage = By.id("delay");
    public DelayPage(WebDriver driver) {
        super(driver);
    }

    public void pressStart(){
        click(find(startButton));
    }
    public Boolean waitDelay(){
        return attributeToBe(find(delayMessage), "value", "Liftoff!");
    }
}
