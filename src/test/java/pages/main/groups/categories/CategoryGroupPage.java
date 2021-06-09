package pages.main.groups.categories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import components.CustomButton;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.PageObject;
import pages.main.groups.categories.group.GroupPage;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class CategoryGroupPage extends PageObject {
    private final String IN_GROUP_TEXT = ".//div[contains(@class,\"tico c-green join-group-result\")]";

    public CategoryGroupPage(WebDriver driver) {
        super(driver);
    }

    @FindAll({@FindBy(xpath = ".//div[contains(@data-l,\"groupId\")]")})
    public List<WebElement> rawGroupCards;

    public List<GroupCard> groupCards;

    @FindBy(xpath = ".//a[contains(@class,\"ml\")]")
    public CustomButton myGroupsButton;

    public UserGroupsListMenu userGroupsListMenu;

    public void joinGroup(int index) {
        groupCards
                .get(index)
                .joinGroupButton
                .clickAndWaitForCondition(driver, visibilityOfElementLocated(By.xpath(IN_GROUP_TEXT)));
    }

    public void openUserGroupsList() {
        myGroupsButton.clickAndWaitForCondition(driver, ExpectedConditions.visibilityOf(userGroupsListMenu.getWrappedElement()));
    }

    public GroupPage getGroupPage(int index) {
        userGroupsListMenu.userGroups.get(index).clickAndWaitForCondition(driver, ExpectedConditions.presenceOfElementLocated(By.xpath(GroupPage.IN_GROUP_BUTTON)));
        return new GroupPage(driver);
    }

}
