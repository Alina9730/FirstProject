import org.junit.Test;
import page_objects.GiftsPage;
import page_objects.MainPage;

public class GiftsPageTest extends BaseTestWithLogin {

    @Test
    public void testGifts() {
        GiftsPage giftsPage = new MainPage(driver).getGiftsPage();
        giftsPage.openCategoryMenu();

        giftsPage.getGiftsConstructorPage().openGiftConstructorPopupMenu();

    }
}
