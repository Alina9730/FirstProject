package page_components;

import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import page_components.custom.CustomButton;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import java.util.List;

@FindBy(xpath = ".//div[contains(@id,\"listBlockPanelDetailedUserGroupsListBlock\")]")
public class UserGroupsListMenu extends HtmlElement {

    @FindAll({@FindBy(xpath = ".//a[contains(@class,\"o two-lines\")]")})
    public List<CustomButton> userGroups;

}
