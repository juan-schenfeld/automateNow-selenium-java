package pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public DelayPage delayPage(){
        click(findByLinkText("JavaScript Delays"));
        return new DelayPage(driver);
    }
}
