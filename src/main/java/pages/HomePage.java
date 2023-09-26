package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    private By delayLink = By.linkText("JavaScript Delays");
    private By sliderLink = By.linkText("Sliders");
    private By popupsLink = By.linkText("Popups");
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public DelayPage delayPage(){
        click(find(delayLink));
        return new DelayPage(driver);
    }

    public SliderPage sliderPage(){
        click(find(sliderLink));
        return new SliderPage(driver);
    }

    public PopupsPage popupsPage(){
        click(find(popupsLink));
        return new PopupsPage(driver);
    }
}
