package pages.main.notes;

import components.CustomButton;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@FindBy(xpath = ".//div[contains(@id,\"hook_Block_PostingForm\")]")
public class NotesMenuField extends HtmlElement {

    @FindBy(xpath = ".//a[contains(@href,\"/post\")]")
    public CustomButton noteButton;
}
