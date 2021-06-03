import org.junit.Test;
import pages.main.gifts.GiftsPage;
import pages.main.MainPage;

public class GiftsPageTest extends BaseTestWithLogin {

    @Test
    public void testGifts() {
        GiftsPage giftsPage = new MainPage(driver).getGiftsPage();
        giftsPage.openCategoryMenu();

        giftsPage.getGiftsConstructorPage().openGiftConstructorPopupMenu();

    }
}
