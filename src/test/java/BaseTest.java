import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class BaseTest {
    public WebDriver driver;
    public String baseUrl;
   // public boolean acceptNextAlert = true;
    public StringBuffer verificationErrors = new StringBuffer();
   // public LoginPage loginPage;



    public void setUp() {
        driver = new ChromeDriver();
        baseUrl = "https://www.google.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void get() {
        driver.manage().window();
        driver.get("https://ok.ru/");
    }

    public void tearDown() {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}