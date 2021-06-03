package pages.main.gifts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.PageObject;
import pages.main.gifts.constructor.GiftsConstructorPage;

public class GiftsPage extends PageObject {

    public GiftsPage(WebDriver driver) {
        super(driver);
    }

    public GiftsHeaderMenu headerMenu;

    public GiftCategoriesPopupMenu popupMenu;

    public void openCategoryMenu() {
        String menuLocator = ".//div[contains(@id,\"mctc_navMenuDropdownSec_popup_categoriesKey\")]";
        headerMenu.giftsButton.clickAndWaitForCondition(driver, ExpectedConditions.visibilityOfElementLocated(By.xpath(menuLocator)));
    }

    public GiftsConstructorPage getGiftsConstructorPage() {
        popupMenu.constructorButton.clickAndWaitForCondition(driver, ExpectedConditions.urlContains("constructor"));
        driver.switchTo().frame("appMain_Div");
        return new GiftsConstructorPage(driver);
    }

//    public static void selectGiftPattern(WebDriver driver) {
//        String patternButton = ".//div[contains(@id,\"id-start_choose_template_btn\")]";
//        //String  menuPattern= ".//div[contains(@id,\"id-photoManagerCnt\")]";
//        common.Utils.pressButtonAndWaitForCondition(driver, patternButton, 3, ExpectedConditions.urlContains("constructor"));
//    }

//driver.switchTo().frame("appMain_Div")  и на следующей строке: driver.findElement(By.Xpath(".//div[contains(@id,"id-start_choose_template_btn")]"))
}
