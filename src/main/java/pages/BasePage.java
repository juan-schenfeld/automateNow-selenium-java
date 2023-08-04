package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    protected WebElement findByLinkText(String text){
        return new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions
                        .visibilityOfElementLocated(By.linkText(text)));
    }

    protected WebElement findById(String id){
        return new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions
                        .visibilityOfElementLocated(By.id(id)));
    }

    protected void click(WebElement element){
        element.click();
    }

    protected Boolean attributeToBe(WebElement element, String attribute, String value){
        return new WebDriverWait(driver, Duration.ofSeconds(11))
                .until(ExpectedConditions.attributeToBe(element, attribute, value));
    }





}
