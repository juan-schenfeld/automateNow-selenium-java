import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 11");
        browserOptions.setBrowserVersion("latest");
        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("username", "oauth-Juan-Schenfeld-P-218f9");
        sauceOptions.put("accessKey", "7f5a33cb-c14b-42d5-8afa-eafa91cc926d");
        sauceOptions.put("build", "selenium-build-1");
        sauceOptions.put("name", "general");
        browserOptions.setCapability("sauce:options", sauceOptions);


        URL url = new URL("https://ondemand.us-west-1.saucelabs.com:443/wd/hub");
        driver = new RemoteWebDriver(url, browserOptions);

//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
        driver.get("https://practice-automation.com/");

        homePage = new HomePage(driver);
    }

    @AfterTest
    void tearDown(){
        driver.close();
    }
}
