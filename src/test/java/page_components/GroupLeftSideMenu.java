package page_components;

import org.openqa.selenium.support.FindBy;
import page_components.custom.CustomButton;
import ru.yandex.qatools.htmlelements.element.HtmlElement;


@FindBy(xpath = ".//div[contains(@class,\"nav-side \")]")
public class GroupLeftSideMenu extends HtmlElement {

    @FindBy(xpath = ".//a[contains(@data-l,\"t,automoto\")]")
    public CustomButton autoMotoButton;

    @FindBy(xpath = ".//a[contains(@data-l,\"t,animals\")]")
    public CustomButton animalsButton;
}
