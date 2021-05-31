import exceptions.LoginException;
import org.junit.Assert;
import org.junit.Test;
import page_objects.GiftsPage;

public class GiftsTest extends BaseTestWithLogin {

    @Test
    public void testGifts() {
        try {
            GiftsPage.goToGiftsPage(driver);
            GiftsPage.openCategoryMenu(driver);
            GiftsPage.goToCreateGiftPage(driver);
        } catch (LoginException e) {
            Assert.fail(e.getMessage());
        }
    }
}
