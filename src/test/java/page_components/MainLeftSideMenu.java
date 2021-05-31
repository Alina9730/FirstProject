package page_components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import page_components.custom.CustomButton;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import java.util.List;

@FindBy(xpath = ".//div[contains(@class,\"nav-side __navigation __user-main\")]")
public class MainLeftSideMenu extends HtmlElement {

    @FindAll({@FindBy(xpath = ".//a[contains(@class,\"nav-side\")]")})
    public List<WebElement> items;

    @FindBy(xpath = ".//div[contains(@data-l,\"t,toggler\")]")
    public CustomButton togglerButton;

    @FindBy(xpath = ".//a[@data-l=\"t,userAltGroup\"]")
    public CustomButton groupButton;
}
