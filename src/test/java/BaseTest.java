import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.HomePage;

public class BaseTest {

    private WebDriver driver;
    HomePage homePage;

    @BeforeTest
    void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://practice-automation.com/");

        homePage = new HomePage(driver);
    }

    @AfterTest
    void tearDown(){
        driver.close();
    }
}
