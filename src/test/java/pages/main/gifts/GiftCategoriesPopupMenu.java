package pages.main.gifts;

import org.openqa.selenium.support.FindBy;
import components.CustomButton;
import ru.yandex.qatools.htmlelements.element.HtmlElement;


@FindBy(xpath = ".//div[contains(@id,\"mctc_navMenuDropdownSec_popup_categoriesKey\")]")
public class GiftCategoriesPopupMenu extends HtmlElement {

    @FindBy(xpath = ".//a[contains(@href,\"/app/constructor\")]")
    public CustomButton constructorButton;
}
