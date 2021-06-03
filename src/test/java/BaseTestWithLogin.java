import common.Literals;
import org.junit.Before;
import pages.LoginPage;

public class BaseTestWithLogin extends BaseTest {
    @Before
    public void start() {
        super.start();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.doLogin(Literals.LOGIN, Literals.PASSWORD);
        loginPage.isLoginSucceed();
    }
}
