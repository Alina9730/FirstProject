import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestCase extends BaseTest {
    UserPage userPage;
    GroupPage groupPage;
    String login = "+79110298964";
    String pass = "RK6eLEm9@@2tcVM";

    @Before
    public void start() {
        setUp();
        get();
    }

    @Test
    public void test() {
        userPage = new LoginPage(driver).checkLogin(login, pass);

        groupPage = userPage.moveToGroups();

        groupPage.checkCategory();
        //Assert.assertTrue(String.valueOf(groupPage.avatarLocators.size()), groupPage.avatarLocators.size() > 0);
    }

    @After
    public void stop() {
        tearDown();
    }
}