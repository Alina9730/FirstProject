package pages.main.groups.categories.group;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import components.CustomButton;
import pages.PageObject;
import pages.main.groups.GroupsPage;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class GroupPage extends PageObject {
    public static String IN_GROUP_BUTTON = ".//a[contains(@class,\"button-pro __wide\")]";
    private String CREATE_GROUP_BUTTON = ".//a[contains(@class,'button-pro __wide __light __ic')]";

    public GroupPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = ".//span[contains(@class,'dropdown_ac button-pro __with-arrow __arrow-svg __sec __wide')]")
    public CustomButton inGroupButton;

    @FindBy(xpath = ".//div[contains(@class,'dropdown_cnt __wide')]")
    public CustomButton leftGroupButton;

    @FindBy(xpath = ".//div[contains(@class,'toolbar_back h-mod')]")
    public CustomButton returnToGroupsPageButton;


    public void leftGroup() {
        inGroupButton.clickAndWaitForCondition(driver, visibilityOf(leftGroupButton));
        leftGroupButton
                .clickAndWaitForCondition(driver, ExpectedConditions.elementToBeClickable(By.xpath(IN_GROUP_BUTTON)));
    }

    public GroupsPage getGroupPage() {
        returnToGroupsPageButton.clickAndWaitForCondition(driver, ExpectedConditions.elementToBeClickable(By.xpath(CREATE_GROUP_BUTTON)));
        return new GroupsPage(driver);
    }

}