package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import page_components.GroupCard;
import page_components.UserGroupsListMenu;
import page_components.custom.CustomButton;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class CategoryGroupPage extends PageObject {

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
                .clickAndWaitForCondition(driver, visibilityOfElementLocated(By.xpath(".//div[contains(@class,\"tico c-green join-group-result\")]")));
    }

    public void openUserGroupsList() {
        myGroupsButton.clickAndWaitForCondition(driver, urlContains("mine"));
    }

    public GroupPage getGroupPage(int index) {
        userGroupsListMenu.userGroups.get(index).clickAndWaitForCondition(driver, not(urlContains("/profile/")));
        return new GroupPage(driver);
    }


//    public void printButtonText() {
//        System.out.println(groupCards.get(0).joinGroupButton.getText());
//    }
}
