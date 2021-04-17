import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver driver;
    private final String loginLocator;
    private final String passLocator;
    private final String signInLocator;

    LoginPage(WebDriver driver) {
        this.driver = driver;
        this.loginLocator = ".//input[@id=\"field_email\"]";
        this.passLocator = ".//input[@id=\"field_password\"]";
        this.signInLocator = ".//input[contains(@data-l,\"t,sign_in\")]";
    }

    public WebDriver doLogin(String login, String pass) {
        driver.findElement(By.xpath(loginLocator)).click();
        driver.findElement(By.xpath(loginLocator)).sendKeys(login);
        driver.findElement(By.xpath(passLocator)).click();
        driver.findElement(By.xpath(passLocator)).sendKeys(pass);
        driver.findElement(By.xpath(signInLocator)).click(); //sendKeys(Keys.ENTER)
        return driver;
    }
}
