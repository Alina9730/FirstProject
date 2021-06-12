package pages.main.gifts.created;

import components.CustomButton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.PageObject;
import java.util.List;

public class CreatedGiftsPage extends PageObject {

    public CreatedGiftsPage(WebDriver driver) {
        super(driver);
    }

    @FindAll({@FindBy(xpath = ".//a[contains(@class,\"gift_a\")]")})
    public List<WebElement> myGifts;

    @FindBy(xpath = ".//div[contains(@class,\"stub-empty __gifts\")]")
    public WebElement noGiftsField;

    @FindBy(xpath = ".//a[contains(@title,\"Удалить\")]")
    private WebElement deleteGift;

    @FindBy(xpath = ".//input[contains(@type,\"submit\")]")
    private WebElement submitDelete;

    public void deleteGift() {
        Actions action = new Actions(driver);
        action.moveToElement(deleteGift).click().build().perform();
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(submitDelete));
        new CustomButton(submitDelete).clickAndWait(500);
    }
}
