import listeners.EventListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertEquals;

@Listeners(EventListener.class)
public class PopupTest extends BaseTest{



    @Test
    public void testAlert(){
        var popupsPage = homePage.popupsPage();
        popupsPage.openAlert();
        String  popupText = popupsPage.getPopupText();
        popupsPage.acceptPopup();

        assertEquals(popupText,"Hi there, pal!","alertPromptText wrong");
    }


    @Test
    public void testDenyAndAcceptConfirm(){
        var popupsPage = homePage.popupsPage();
        SoftAssert softAssert = new SoftAssert();

        popupsPage.openConfirm();
        String  popupText = popupsPage.getPopupText();

        popupsPage.acceptPopup();
        String confirmAcceptResult = popupsPage.getConfirmResult();

        popupsPage.openConfirm();
        popupsPage.denyPopup();
        String confirmDenyResult = popupsPage.getConfirmResult();

        softAssert.assertEquals(popupText,"OK or Cancel, which will it be?", "confirmPopupText wrong");
        softAssert.assertEquals(confirmAcceptResult, "OK it is!", "confirmAcceptResult wrong");
        softAssert.assertEquals(confirmDenyResult, "Cancel it is!","confirmDenyResult wrong");
        softAssert.assertAll();

    }

    @Test
    public void testDenyAcceptAndSendKeysPrompt(){

        var popupsPage = homePage.popupsPage();
        String textToSend = "automation";
        SoftAssert softAssert = new SoftAssert();

        popupsPage.openPrompt();
        String  popupText = popupsPage.getPopupText();

        popupsPage.sendKeysToPopup(textToSend);

        popupsPage.acceptPopup();
        String promptAcceptResult = popupsPage.getPromptResult();

        popupsPage.openPrompt();
        popupsPage.denyPopup();
        String promptDenyResult = popupsPage.getPromptResult();

        softAssert.assertEquals(popupText,"Hi there, what's your name?", "promptPopupText wrong");
        softAssert.assertEquals(promptAcceptResult, "Nice to meet you, "+textToSend+"!", "promptAcceptResult wrong");
        softAssert.assertEquals(promptDenyResult, "Fine, be that way...","promptDenyResult wrong");
        softAssert.assertAll();

    }

}
