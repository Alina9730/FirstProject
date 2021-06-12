import org.hamcrest.Matchers;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.main.gifts.GiftsPage;
import pages.main.MainPage;
import pages.main.gifts.constructor.ConstructorPage;
import pages.main.gifts.constructor.PopupMenu;
import pages.main.gifts.created.CreatedGiftsPage;
import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.matchers.webdriver.DisplayedMatcher.displayed;

public class GiftsPageTest extends BaseTestWithLogin {

    @Test
    public void testGifts() {
        GiftsPage giftsPage = new MainPage(driver).getGiftsPage();

        giftsPage.openMyGiftsMenu();
        assertThat(giftsPage.getCreatedGiftsPage().noGiftsField, displayed());

        giftsPage.openCategoryMenu();

        ConstructorPage constructorPage = giftsPage.getConstructorPage();
        constructorPage.openPopupMenu();
        PopupMenu popup = constructorPage.popupMenu;
        popup.animalsButton
                .clickAndWait(100);
        popup.getGiftsCards(driver).get(0)
                .clickAndWaitForCondition(driver, ExpectedConditions.elementToBeClickable(constructorPage.giftReadyButton));

        constructorPage.giftReadyButton.clickAndWaitForCondition(driver, 5, ExpectedConditions.elementToBeClickable(constructorPage.sendGiftButton));
        CreatedGiftsPage createdGiftsPage = constructorPage.getCreatedGiftsPage();
        assertThat(createdGiftsPage.myGifts.size(), Matchers.is(1));

        createdGiftsPage.deleteGift();
        assertThat(createdGiftsPage.noGiftsField, displayed());
    }
}
