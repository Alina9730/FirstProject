package pages.main.gifts;

import org.openqa.selenium.support.FindBy;
import components.CustomButton;
import ru.yandex.qatools.htmlelements.element.HtmlElement;


@FindBy(xpath = ".//div[contains(@class,\"gifts-header_navigation-block\")]")
public class GiftsHeaderMenu extends HtmlElement {

    @FindBy(xpath = ".//span[contains(@id,\"mctc_navMenuDropdownSec_categoriesKey\")]")
    public CustomButton giftsButton;
}
