package pages.main.groups;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.PageObject;
import pages.main.groups.categories.CategoryGroupPage;

public class GroupsPage extends PageObject {

    public GroupsPage(WebDriver driver) {
        super(driver);
    }

    public GroupsLeftSideMenu leftMenu;

    public CategoryGroupPage getAutoMotoPage () {
        leftMenu.autoMotoButton.clickAndWaitForCondition(driver, ExpectedConditions.urlContains("automoto"));
        return new CategoryGroupPage(driver);
    }

    public CategoryGroupPage getAnimalsPage () {
        leftMenu.animalsButton.clickAndWaitForCondition(driver, ExpectedConditions.urlContains("animals"));
        return new CategoryGroupPage(driver);
    }

}