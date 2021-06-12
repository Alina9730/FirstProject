package pages.main.groups;

import org.openqa.selenium.support.FindBy;
import components.CustomButton;
import ru.yandex.qatools.htmlelements.element.HtmlElement;


@FindBy(xpath = ".//div[contains(@class,\"nav-side \")]")
public class LeftSideMenu extends HtmlElement {

    @FindBy(xpath = ".//a[contains(@data-l,\"t,automoto\")]")
    public CustomButton autoMotoButton;

    @FindBy(xpath = ".//a[contains(@data-l,\"t,animals\")]")
    public CustomButton animalsButton;
}
