import common.Literals;
import org.junit.Test;
import page_objects.LoginPage;

public class LoginPageTest extends BaseTest {

    @Test
    public void test() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.doLogin(Literals.LOGIN, Literals.PASSWORD);
    }

}