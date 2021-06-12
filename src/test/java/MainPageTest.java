import org.hamcrest.Matchers;
import org.junit.Test;
import pages.main.MainPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static pages.main.LeftSideMenu.*;

public class MainPageTest extends BaseTestWithLogin {
    @Test
    public void testMenuItemsVisibility() {
        MainPage mainPage = new MainPage(driver);

        assertThat(mainPage.leftMenu.getVisibleItemsSize(), Matchers.is(INITIAL_MENU_SIZE));

        // нажимаем кнопку "Ещё" на тулбаре user-main, ждём после этого 100 миллисекунд для обновления списка меню
        mainPage.leftMenu.pressTogglerButton(driver, 100);
        assertThat(mainPage.leftMenu.getVisibleItemsSize(), Matchers.is(INITIAL_MENU_SIZE + ADDITIONAL_MENU_SIZE));

        // нажимаем кнопку "Скрыть" на тулбаре user-main, ждём после этого 500 миллисекунд для обновления списка меню
        mainPage.leftMenu.pressTogglerButton(driver, 500);
        assertThat(mainPage.leftMenu.getVisibleItemsSize(), Matchers.is(INITIAL_MENU_SIZE));
    }
}
