import exceptions.LoginException;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.matchers.webdriver.DisplayedMatcher.displayed;

public class GroupTest extends BaseTest {

    @Test
    public void testAutoMotoAvatars() {
        try {
            GroupPage.goToAutoMotoPage(driver);
            assertThat(GroupPage.getAvatars(driver), everyItem(displayed()));
        } catch (LoginException e) {
            Assert.fail(e.getMessage());
        }
    }
}
