package pages.main;

import components.CustomButton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.PageObject;
import pages.main.gifts.GiftsPage;
import pages.main.groups.GroupsPage;
import pages.main.notes.NotesMenuField;
import pages.main.notes.NotesPage;


import static pages.main.groups.categories.group.GroupPage.CREATE_GROUP_BUTTON;

public class MainPage extends PageObject {
    private static String popularButton = ".//a[contains(@class,\"mctc_navMenuSec  mctc_navMenuActiveSec\")]";
    private static String repostButton = ".//button[contains(@data-l,\"t,re\")]";
    private static String likeButton = ".//div[contains(@class,\"widget  __wide-count\")]";

    @FindBy(xpath = ".//a[contains(@data-l,\"t,.k\")]")
    public CustomButton commentButton;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainLeftSideMenu leftMenu;
    public NotesMenuField notesMenu;

    public GroupsPage getGroupsPage() {
        leftMenu.groupsButton.clickAndWaitForCondition(driver, ExpectedConditions.elementToBeClickable(By.xpath(CREATE_GROUP_BUTTON)));
        return new GroupsPage(driver);
    }

    public GiftsPage getGiftsPage() {
        leftMenu.giftsButton.clickAndWaitForCondition(driver, ExpectedConditions.elementToBeClickable(By.xpath(popularButton)));
        return new GiftsPage(driver);
    }

    public NotesPage getNotesPage(){
        notesMenu.noteButton.clickAndWaitForCondition(driver, ExpectedConditions.elementToBeClickable(By.xpath(repostButton)));
        return new NotesPage(driver);
    }

//    public NotesPageLeftMenu getNotesPageLeftMenu (){
//        leftMenu.notesButton.clickAndWaitForCondition(driver, ExpectedConditions.elementToBeClickable(By.xpath(likeButton)));
//        return new NotesPageLeftMenu(driver);
//    }
}
