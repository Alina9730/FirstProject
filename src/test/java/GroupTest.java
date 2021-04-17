import org.junit.Assert;
import org.junit.Test;

public class GroupTest extends BaseTest {

    @Test
    public void testAutoMotoAvatars() {
        GroupPage groupPage;
        try {
            groupPage = GroupPageFactory.getAutoMotoPage(driver);
            Assert.assertTrue(groupPage.isAllAvatarsDisplayed());
        } catch (LoginException e) {
            Assert.fail(e.cause);
        }
    }
}
