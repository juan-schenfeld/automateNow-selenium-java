import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.HomePage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class  BaseTest {

    private RemoteWebDriver driver;
    HomePage homePage;

    @BeforeTest
    void setUp() throws MalformedURLException {

        String accessKey = System.getenv("SAUCELABS_KEY");

        ChromeOptions browserOptions = getChromeOptions(accessKey);


        URL url = new URL("https://ondemand.us-west-1.saucelabs.com:443/wd/hub");
        driver = new RemoteWebDriver(url, browserOptions);

//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
        driver.get("https://practice-automation.com/");

        homePage = new HomePage(driver);
    }

    private static ChromeOptions getChromeOptions(String accessKey) {
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 11");
        browserOptions.setBrowserVersion("latest");
        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("username", "oauth-Juan-Schenfeld-P-218f9");
        sauceOptions.put("accessKey", accessKey);
        sauceOptions.put("build", "selenium-build-1");
        sauceOptions.put("name", "general");
        browserOptions.setCapability("sauce:options", sauceOptions);
        return browserOptions;
    }

    @AfterTest
    void tearDown(){
        driver.close();
    }
}
