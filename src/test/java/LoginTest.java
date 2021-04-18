import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class LoginTest extends BaseTest {

    @Test
    public void test() {
        // Константы?
        String login = "+79110298964";
        String pass = "RK6eLEm9@@2tcVM";
        LoginPage loginPage = new LoginPage(super.driver);

        WebDriver driver = loginPage.doLogin(login, pass);

        Assert.assertTrue(LoginPage.isLoggedIn(driver));
    }

}