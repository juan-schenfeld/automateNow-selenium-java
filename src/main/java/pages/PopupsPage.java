package pages;

import org.openqa.selenium.WebDriver;

public class PopupsPage extends BasePage{



    public PopupsPage(WebDriver driver) {
        super(driver);
    }

    public void openAlert(){
        click(findById("alert"));
    }
    public void openConfirm(){
        click(findById("confirm"));
    }
    public void openPrompt(){
        click(findById("prompt"));
    }
    public String getPopupText(){
        return driver.switchTo().alert().getText();
    }

    public String getConfirmResult(){
        return findById("confirmResult").getText();
    }

    public String getPromptResult(){
        return findById("promptResult").getText();
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
