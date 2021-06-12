package pages.main.gifts;

import components.CustomButton;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@FindBy(xpath = ".//div[contains(@id,\"mctc_navMenuDropdownSec_popup_myGiftsKey\")]")
public class MyGiftsPopupMenu extends HtmlElement {

    @FindBy(xpath = ".//a[contains(@href,\"/gifts/uploaded\")]")
    public CustomButton createdGiftsButton;
}
