package pages.main.groups.categories;

import org.openqa.selenium.support.FindBy;
import components.CustomButton;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@FindBy(xpath = ".//div[contains(@data-l,\"groupId\")]")
public class GroupCard extends HtmlElement {

    @FindBy(xpath = ".//a[contains(@class,\"button-pro group-join_btn __small __sec\")]")
    public CustomButton joinGroupButton;

}