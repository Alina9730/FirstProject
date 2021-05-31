import common.Literals;
import org.junit.Test;
import page_objects.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void test() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.doLogin(Literals.LOGIN, Literals.PASSWORD);
    }

}