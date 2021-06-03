import common.Literals;
import org.junit.Test;
import pages.LoginPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.not;
import static ru.yandex.qatools.matchers.webdriver.DisplayedMatcher.displayed;

public class LoginPageTest extends BaseTest {

    @Test
    public void test() {
        LoginPage loginPage = new LoginPage(driver);
        assertThat(loginPage.signInButton, displayed());

        loginPage.doLogin(Literals.LOGIN, Literals.PASSWORD);
        assertThat(loginPage.signInButton, not(displayed()));
    }
}