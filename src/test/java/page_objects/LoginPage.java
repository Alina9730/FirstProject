package page_objects;

import exceptions.LoginException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends PageObject {

    @FindBy(id = "field_email")
    private WebElement email;

    @FindBy(id = "field_password")
    private WebElement password;

    @FindBy(xpath = ".//input[contains(@data-l,\"t,sign_in\")]")
    private WebElement signInButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private void checkLoginException() {
        if (driver.getCurrentUrl().contains("password.wrong")) throw new LoginException("Incorrect login or password!");
    }

    public void doLogin(String login, String pass) {
        email.sendKeys(login);
        password.sendKeys(pass);
        signInButton.click();
        checkLoginException();
    }
}
