import exceptions.LoginException;
import org.junit.Assert;
import org.junit.Test;

public class GiftsTest extends BaseTest {

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
