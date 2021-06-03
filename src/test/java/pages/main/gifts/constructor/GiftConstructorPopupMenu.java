package pages.main.gifts.constructor;

import org.openqa.selenium.support.FindBy;
import components.CustomButton;
import ru.yandex.qatools.htmlelements.element.HtmlElement;


@FindBy(xpath = ".//div[contains(@id,\"id-album_layer\")]")
public class GiftConstructorPopupMenu extends HtmlElement {

    @FindBy(xpath = ".//a[contains(@href,\"/app/constructor\")]")
    public CustomButton constructorButton;
}
