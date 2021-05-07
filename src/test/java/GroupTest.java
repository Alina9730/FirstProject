import org.junit.Assert;
import org.junit.Test;

public class GroupTest extends BaseTest {

    @Test
    public void testAutoMotoAvatars() {
        GroupPage autoMotoGroupPage;
        try {
            autoMotoGroupPage = GroupPageFactory.getAutoMotoPage(driver);
            Assert.assertTrue(autoMotoGroupPage.isAllAvatarsDisplayed());
        } catch (LoginException e) {
            Assert.fail(e.cause);
        }
    }
}
