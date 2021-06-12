package pages.main.gifts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.PageObject;
import pages.main.gifts.constructor.ConstructorPage;
import pages.main.gifts.created.CreatedGiftsPage;
import static pages.main.gifts.constructor.ConstructorPage.TEMPLATE_BUTTON;

public class GiftsPage extends PageObject {
    private final String GIFTS_MAIN_FRAME = ".//iframe[contains(@id,\"appMain_Div\")]";

    public GiftsPage(WebDriver driver) {
        super(driver);
    }

    private HeaderMenu headerMenu;

    private CategoriesPopupMenu categoriesPopupMenu;

    private MyGiftsPopupMenu myGiftsPopupMenu;

    public void openCategoryMenu() {
        headerMenu.categoriesButton.clickAndWaitForCondition(driver, ExpectedConditions.visibilityOf(categoriesPopupMenu.getWrappedElement()));
    }

    public void openMyGiftsMenu() {
        headerMenu.myGiftsButton.clickAndWaitForCondition(driver, ExpectedConditions.visibilityOf(myGiftsPopupMenu.getWrappedElement()));
    }

    public ConstructorPage getConstructorPage() {
        categoriesPopupMenu.constructorButton.clickAndWaitForCondition(driver, ExpectedConditions.presenceOfElementLocated(By.xpath(GIFTS_MAIN_FRAME)));
        driver.switchTo().frame("appMain_Div");
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TEMPLATE_BUTTON)));
        return new ConstructorPage(driver);
    }

    public CreatedGiftsPage getCreatedGiftsPage() {
        myGiftsPopupMenu.createdGiftsButton.clickAndWait(500);
        return new CreatedGiftsPage(driver);
    }
}
