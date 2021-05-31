import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import page_objects.MainPage;

import java.util.List;

import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.matchers.webdriver.DisplayedMatcher.displayed;

public class MainPageTest extends BaseTestWithLogin {
    @Test
    public void testMenuItemsVisibility() {
        MainPage mainPage = new MainPage(driver);

        List<WebElement> menuItems = mainPage.leftMenu.items;

        assertThat(menuItems, not(everyItem(displayed())));

        try {
            // нажимаем кнопку "Ещё" на тулбаре user-main, ждём после этого 500 миллисекунд для обновления списка меню
            mainPage.leftMenu.togglerButton.clickAndWait(500);
            assertThat(menuItems, everyItem((displayed())));

            // нажимаем кнопку "Скрыть" на тулбаре user-main, ждём после этого 1000 миллисекунд для обновления списка меню
            mainPage.leftMenu.togglerButton.clickAndWait(1000);
            assertThat(menuItems, not(everyItem(displayed())));
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }
}
