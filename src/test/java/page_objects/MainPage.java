package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import page_components.MainLeftSideMenu;

public class MainPage extends PageObject {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainLeftSideMenu leftMenu;

    public GroupPage getGroupPage() {
        leftMenu.groupButton.clickAndWaitForCondition(driver, 3, ExpectedConditions.urlContains("profile"));
        return new GroupPage(driver);
    }
}
