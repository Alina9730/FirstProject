package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import page_components.GroupLeftSideMenu;

public class GroupPage extends PageObject {

    public GroupPage(WebDriver driver) {
        super(driver);
    }

    public GroupLeftSideMenu leftMenu;

    public CategoryGroupPage getAutoMotoPage () {
        leftMenu.autoMotoButton.clickAndWaitForCondition(driver, 3, ExpectedConditions.urlContains("automoto"));
        return new CategoryGroupPage(driver);
    }

    public CategoryGroupPage getAnimalsPage () {
        leftMenu.animalsButton.clickAndWaitForCondition(driver, 3, ExpectedConditions.urlContains("animals"));
        return new CategoryGroupPage(driver);
    }

}