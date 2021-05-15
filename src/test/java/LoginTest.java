import org.junit.Assert;
import org.junit.Test;

public class LoginTest extends BaseTest {

    @Test
    public void test() {
        LoginPage.doLogin(driver, Literals.LOGIN, Literals.PASSWORD);

        Assert.assertTrue(LoginPage.isLoggedIn(driver));
    }

}