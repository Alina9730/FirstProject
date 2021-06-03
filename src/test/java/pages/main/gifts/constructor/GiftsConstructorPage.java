package pages.main.gifts.constructor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import components.CustomButton;
import pages.PageObject;

public class GiftsConstructorPage extends PageObject {

    public GiftsConstructorPage(WebDriver driver) {
        super(driver);
    }

    public GiftConstructorPopupMenu popupMenu;

    @FindBy(xpath = ".//div[contains(@id,\"id-start_choose_template_btn\")]")
    private CustomButton templateButton;

    public void openGiftConstructorPopupMenu() {
        String buttonLocator = ".//div[contains(@id,\"id-start_choose_template_btn\")]";
        String menuLocator = ".//div[contains(@id,\"mctc_navMenuDropdownSec_popup_categoriesKey\")]";
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(buttonLocator)));
        templateButton.clickAndWaitForCondition(driver, ExpectedConditions.visibilityOfElementLocated(By.xpath(menuLocator)));
        System.out.println(templateButton.getWrappedElement().getAttribute("id"));
    }
}
