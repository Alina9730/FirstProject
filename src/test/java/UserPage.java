import exceptions.LoginException;
import org.openqa.selenium.WebDriver;

public class UserPage {

    public static void goToUserPage(WebDriver driver, String login, String pass) throws LoginException {
        driver.get(Literals.OK_MAIN_PAGE);
        if (LoginPage.isLoggedIn(driver)) {
        } else {
            LoginPage.doLogin(driver, login, pass);
            if (LoginPage.isLoggedIn(driver)) {
            } else {
                throw new LoginException("Incorrect login or password!");
            }
        }
    }


}