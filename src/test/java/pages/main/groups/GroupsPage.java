package pages.main.groups;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.PageObject;
import pages.main.groups.categories.CategoryGroupPage;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class GroupsPage extends PageObject {
    private final String CATEGORY_TITLE = ".//div[contains(@class,\"portlet_h_title\")]";

    public GroupsPage(WebDriver driver) {
        super(driver);
    }

    public LeftSideMenu leftMenu;

    public CategoryGroupPage getAutoMotoPage () {

        leftMenu.autoMotoButton.clickAndWaitForCondition(driver, visibilityOfElementLocated(By.xpath(CATEGORY_TITLE)));
        return new CategoryGroupPage(driver);
    }

    public CategoryGroupPage getAnimalsPage () {
        leftMenu.animalsButton.clickAndWaitForCondition(driver, visibilityOfElementLocated(By.xpath(CATEGORY_TITLE)));
        return new CategoryGroupPage(driver);
    }

}