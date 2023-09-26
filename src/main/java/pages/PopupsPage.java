package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PopupsPage extends BasePage{

    private By alertButton = By.id("alert");
    private By confirmButton = By.id("confirm");
    private By promptButton = By.id("prompt");
    private By confirmResultText = By.id("confirmResult");
    private By promptResultText = By.id("promptResult");



    public PopupsPage(WebDriver driver) {
        super(driver);
    }

    public void openAlert(){
        click(find(alertButton));
    }
    public void openConfirm(){
        click(find(confirmButton));
    }
    public void openPrompt(){
        click(find(promptButton));
    }
    public String getPopupText(){
        return driver.switchTo().alert().getText();
    }

    public String getConfirmResult(){
        return find(confirmResultText).getText();
    }

    public String getPromptResult(){
        return find(promptResultText).getText();
    }

    public void acceptPopup(){
        driver.switchTo().alert().accept();
    }

    public void denyPopup(){
        driver.switchTo().alert().dismiss();
    }

    public void sendKeysToPopup(String keys){
        driver.switchTo().alert().sendKeys(keys);
    }







}
