import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class LoginTest extends BaseTest {

    @Test
    public void test() {
        LoginPage loginPage = new LoginPage(super.driver);

        WebDriver driver = loginPage.doLogin(Literals.LOGIN, Literals.PASSWORD);

        Assert.assertTrue(LoginPage.isLoggedIn(driver));
    }

}