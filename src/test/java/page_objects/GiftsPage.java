package page_objects;

import common.Literals;
import common.Utils;
import exceptions.LoginException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GiftsPage {

    public static void goToGiftsPage(WebDriver driver) throws LoginException {
        String giftsButton = ".//a[contains(@data-l,\"t,giftsFront\")]";

//        UserPage.goToUserPage(driver, Literals.LOGIN, Literals.PASSWORD);

        Utils.pressButtonAndWaitForCondition(driver, giftsButton, 3, ExpectedConditions.urlContains("gifts"));
    }

    public static void openCategoryMenu(WebDriver driver) {
        String categoriesButton = ".//span[contains(@id,\"mctc_navMenuDropdownSec_categoriesKey\")]";
        String menuLocator = ".//div[contains(@id,\"mctc_navMenuDropdownSec_popup_categoriesKey\")]";
        Utils.pressButtonAndWaitForCondition(driver, categoriesButton, 3, ExpectedConditions.visibilityOfElementLocated(By.xpath(menuLocator)));
    }

    public static void goToCreateGiftPage(WebDriver driver) {
        String categoriesButton = ".//a[contains(@href,\"/app/constructor\")]";
        Utils.pressButtonAndWaitForCondition(driver, categoriesButton, 3, ExpectedConditions.urlContains("constructor"));
    }

//    public static void selectGiftPattern(WebDriver driver) {
//        String patternButton = ".//div[contains(@id,\"id-start_choose_template_btn\")]";
//        //String  menuPattern= ".//div[contains(@id,\"id-photoManagerCnt\")]";
//        common.Utils.pressButtonAndWaitForCondition(driver, patternButton, 3, ExpectedConditions.urlContains("constructor"));
//    }


}
