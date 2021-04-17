import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver driver;
    private final static String signInLocator = ".//input[contains(@data-l,\"t,sign_in\")]";

    LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public static boolean isLoggedIn(WebDriver driver) {
        return driver.findElements(By.xpath(signInLocator)).isEmpty();
    }

    public WebDriver doLogin(String login, String pass) {
        String loginLocator = ".//input[@id=\"field_email\"]";
        String passLocator = ".//input[@id=\"field_password\"]";

        driver.findElement(By.xpath(loginLocator)).click();
        driver.findElement(By.xpath(loginLocator)).sendKeys(login);
        driver.findElement(By.xpath(passLocator)).click();
        driver.findElement(By.xpath(passLocator)).sendKeys(pass);
        driver.findElement(By.xpath(signInLocator)).click(); //sendKeys(Keys.ENTER)
        return driver;
    }
}
