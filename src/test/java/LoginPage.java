import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    // Для каждого объекта LoginPage свой драйвер?
    private final WebDriver driver;
    // Обычно константы записываются как SIGN_IN_LOCATOR, так переменную проще идентифицировать как константную
    private final static String signInLocator = ".//input[contains(@data-l,\"t,sign_in\")]";

    LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public static boolean isLoggedIn(WebDriver driver) {
        return driver.findElements(By.xpath(signInLocator)).isEmpty();
    }

    public WebDriver doLogin(String login, String pass) {
        // Может стоит вынести в константы?
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
