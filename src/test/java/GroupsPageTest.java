import org.hamcrest.Matchers;
import org.junit.Test;
import pages.main.groups.categories.CategoryGroupPage;
import pages.main.groups.categories.group.GroupPage;
import pages.main.MainPage;

import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.matchers.webdriver.DisplayedMatcher.displayed;
import static ru.yandex.qatools.matchers.webdriver.TextMatcher.text;
import static org.hamcrest.CoreMatchers.not;

public class GroupsPageTest extends BaseTestWithLogin {

    @Test
    public void testAutoMotoAvatars() {

        CategoryGroupPage categoryGroupPage =
                new MainPage(driver)
                        .getGroupsPage()
                        .getAutoMotoPage();

        assertThat(categoryGroupPage.rawGroupCards, everyItem(displayed()));
    }

    @Test
    public void testAnimalsAvatars() {

        CategoryGroupPage categoryGroupPage =
                new MainPage(driver)
                        .getGroupsPage()
                        .getAnimalsPage();

        assertThat(categoryGroupPage.rawGroupCards, everyItem(displayed()));
    }

    @Test
    public void testJoinGroup() {

        int TEST_GROUP_INDEX = 0;

        CategoryGroupPage autoMotoPage =
                new MainPage(driver)
                        .getGroupsPage()
                        .getAutoMotoPage();

        assertThat(autoMotoPage.myGroupsButton, not(displayed()));
        assertThat(autoMotoPage.groupCards.get(TEST_GROUP_INDEX).joinGroupButton, text("Вступить"));

        autoMotoPage.joinGroup(TEST_GROUP_INDEX);
        autoMotoPage.refreshPage();

        assertThat(autoMotoPage.myGroupsButton, displayed());
        assertThat(autoMotoPage.userGroupsListMenu, not(displayed()));

        autoMotoPage.openUserGroupsList();

        assertThat(autoMotoPage.userGroupsListMenu.userGroups.size(), Matchers.is(1));

        GroupPage groupPage = autoMotoPage.getGroupPage(TEST_GROUP_INDEX);

        assertThat(groupPage.inGroupButton, text("В группе"));

        groupPage.leftGroup();

        autoMotoPage = groupPage.getGroupPage().getAutoMotoPage();

        assertThat(autoMotoPage.myGroupsButton, not(displayed()));
    }
}
