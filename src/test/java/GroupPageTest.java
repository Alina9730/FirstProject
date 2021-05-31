import org.junit.Test;
import page_objects.CategoryGroupPage;
import page_objects.MainPage;

import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.matchers.webdriver.DisplayedMatcher.displayed;

public class GroupPageTest extends BaseTestWithLogin {

    @Test
    public void testAutoMotoAvatars() {

        CategoryGroupPage categoryGroupPage =
                new MainPage(driver)
                        .getGroupPage()
                        .getAutoMotoPage();

        assertThat(categoryGroupPage.groupCards, everyItem(displayed()));
    }

    @Test
    public void testAnimalsAvatars() {

        CategoryGroupPage categoryGroupPage =
                new MainPage(driver)
                        .getGroupPage()
                        .getAnimalsPage();

        assertThat(categoryGroupPage.groupCards, everyItem(displayed()));
    }
}
