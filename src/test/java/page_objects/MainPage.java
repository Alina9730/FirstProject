package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import page_components.MainLeftSideMenu;

public class MainPage extends PageObject {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainLeftSideMenu leftMenu;

    public GroupsPage getGroupsPage() {
        leftMenu.groupsButton.clickAndWaitForCondition(driver, ExpectedConditions.urlContains("profile"));
        return new GroupsPage(driver);
    }

    public GiftsPage getGiftsPage() {
        leftMenu.giftsButton.clickAndWaitForCondition(driver, ExpectedConditions.urlContains("gifts"));
        return new GiftsPage(driver);
    }
}
