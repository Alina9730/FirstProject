import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.matchers.webdriver.DisplayedMatcher.displayed;

import java.util.List;

public class UserPageTest extends BaseTest {

    private static final List<String> MENU_ITEMS_LOCATORS = List.of(
            ".//a[contains(@data-l,\"t,youlaAdverts\")]",
            ".//a[contains(@data-l,\"t,eventsCalendar\")]",
            ".//a[contains(@data-l,\"t,bookmarks\")]",
            ".//a[contains(@data-l,\"t,userProfile\")]",
            ".//a[contains(@data-l,\"t,auctionsMain\")]",
            ".//a[contains(@data-l,\"t,bizApps\")]",
            ".//a[contains(@data-l,\"t,businessProfileCabinet\")]",
            ".//a[contains(@data-l,\"t,adsManagerMain\")]"
    );

    @Test
    public void testMenuItemsVisibility() {
        try {
            UserPage.goToUserPage(driver, Literals.LOGIN, Literals.PASSWORD);

            List<WebElement> menuItems = Utils.getWebElementsList(driver, MENU_ITEMS_LOCATORS);
            assertThat(menuItems, everyItem(not(displayed())));

            // нажимаем кнопку "Ещё" на тулбаре user-main, ждём после этого 500 миллисекунд для обновления списка меню
            Utils.pressButton(driver, ".//div[contains(@data-l,\"t,toggler\")]");
            Thread.sleep(500);
            assertThat(menuItems, everyItem((displayed())));

            // нажимаем кнопку "Скрыть" на тулбаре user-main, ждём после этого 500 миллисекунд для обновления списка меню
            Utils.pressButton(driver, ".//div[contains(@data-l,\"t,toggler\")]");
            Thread.sleep(1000);
            assertThat(menuItems, everyItem(not(displayed())));

        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }
}
