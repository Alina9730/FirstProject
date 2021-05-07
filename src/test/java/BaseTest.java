import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    public WebDriver driver;

    private void initDriver() {
        driver = new ChromeDriver();
    }

    private void getOkPage() {
        driver.manage().window();
        driver.get(Literals.OK_MAIN_PAGE);
    }

    private void closeDriver() {
        driver.quit();
    }

    @Before
    public void start() {
        initDriver();
        getOkPage();
    }

    @After
    public void stop() {
        closeDriver();
    }
}