import org.junit.Test;
import pages.main.MainPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.matchers.webdriver.DisplayedMatcher.displayed;

public class NotesPageTest extends BaseTestWithLogin{
    @Test
    public void testExistNotes (){
        MainPage mainPage = new MainPage(driver);
        mainPage.getNotesPage().doNote("note1");

        assertThat(mainPage.commentButton, displayed());
    }
}
