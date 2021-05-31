package page_components;

import org.openqa.selenium.support.FindBy;
import page_components.custom.CustomButton;
import ru.yandex.qatools.htmlelements.element.HtmlElement;


@FindBy(xpath = ".//div[contains(@class,\"nav-side \")]")
public class GroupLeftSideMenu extends HtmlElement {

//    @FindAll({@FindBy(xpath = ".//a[contains(@class,\"nav-side\")]")})
//    public List<WebElement> items;

    @FindBy(xpath = ".//a[contains(@data-l,\"t,automoto\")]")
    public CustomButton autoMotoButton;

    @FindBy(xpath = ".//a[contains(@data-l,\"t,animals\")]")
    public CustomButton animalsButton;
}
