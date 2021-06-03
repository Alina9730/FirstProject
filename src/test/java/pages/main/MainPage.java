package pages.main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.PageObject;
import pages.main.gifts.GiftsPage;
import pages.main.groups.GroupsPage;

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
