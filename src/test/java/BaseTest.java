import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class  BaseTest {

    private RemoteWebDriver driver;
    HomePage homePage;

    @BeforeMethod
    void setUp() throws MalformedURLException {

        String accessKey = System.getenv("SAUCELABS_KEY");
        String username = System.getenv("SAUCELABS_USERNAME");
        if(accessKey==null){
            driver = new ChromeDriver();
        } else {
            ChromeOptions browserOptions = getChromeOptions(accessKey, username);
            URL url = new URL("https://ondemand.us-west-1.saucelabs.com:443/wd/hub");
            driver = new RemoteWebDriver(url, browserOptions);
        }

        driver.get("https://practice-automation.com/");
        homePage = new HomePage(driver);
    }

    private static ChromeOptions getChromeOptions(String accessKey, String username) {
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 11");
        browserOptions.setBrowserVersion("latest");
        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("username", username);
        sauceOptions.put("accessKey", accessKey);
        sauceOptions.put("build", "selenium-build-1");
        sauceOptions.put("name", "general");
        browserOptions.setCapability("sauce:options", sauceOptions);
        return browserOptions;
    }

    @AfterMethod
    void tearDown(){
        driver.close();
    }
}
