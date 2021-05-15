import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final static String SIGN_IN_LOCATOR = ".//input[contains(@data-l,\"t,sign_in\")]";

    public static boolean isLoggedIn(WebDriver driver) {
        return driver.findElements(By.xpath(SIGN_IN_LOCATOR)).isEmpty();
    }

    public static void doLogin(WebDriver driver, String login, String pass) {
        String LOGIN_LOCATOR = ".//input[@id=\"field_email\"]";
        String PASS_LOCATOR = ".//input[@id=\"field_password\"]";

        Utils.pressButton(driver, LOGIN_LOCATOR);
        driver.findElement(By.xpath(LOGIN_LOCATOR)).sendKeys(login);
        Utils.pressButton(driver, PASS_LOCATOR);
        driver.findElement(By.xpath(PASS_LOCATOR)).sendKeys(pass);
        Utils.pressButton(driver, SIGN_IN_LOCATOR); //sendKeys(Keys.ENTER)
    }
}
