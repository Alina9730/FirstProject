package pages.main;

import components.CustomButton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.PageObject;
import pages.main.gifts.GiftsPage;
import pages.main.groups.GroupsPage;
import static pages.main.groups.categories.group.GroupPage.CREATE_GROUP_BUTTON;

public class MainPage extends PageObject {
    private static String popularButton = ".//a[contains(@class,\"mctc_navMenuSec  mctc_navMenuActiveSec\")]";

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public LeftSideMenu leftMenu;

    public GroupsPage getGroupsPage() {
        leftMenu.groupsButton.clickAndWaitForCondition(driver, ExpectedConditions.elementToBeClickable(By.xpath(CREATE_GROUP_BUTTON)));
        return new GroupsPage(driver);
    }

    public GiftsPage getGiftsPage() {
        leftMenu.giftsButton.clickAndWaitForCondition(driver, ExpectedConditions.elementToBeClickable(By.xpath(popularButton)));
        return new GiftsPage(driver);
    }
}
