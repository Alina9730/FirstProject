package pages.main.gifts.constructor;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import components.CustomButton;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.PageObject;
import pages.main.gifts.created.CreatedGiftsPage;

import java.awt.*;
import java.awt.event.KeyEvent;

public class ConstructorPage extends PageObject {
    public static final String TEMPLATE_BUTTON = ".//div[contains(@id,\"id-start_choose_template_btn\")]";

    public ConstructorPage(WebDriver driver) {
        super(driver);
    }

    public PopupMenu popupMenu;

    @FindBy(xpath = TEMPLATE_BUTTON)
    private CustomButton templateButton;

    @FindBy(xpath = ".//div[contains(@id,\"id-ready_present_btn\")]")
    public CustomButton giftReadyButton;

    @FindBy(xpath = ".//div[contains(@id,\"id-send128\")]")
    public CustomButton sendGiftButton;

    @FindBy(xpath = ".//a[contains(@id,\"id-goto_my_present_result\")]")
    private WebElement myCreatedGiftsButton;

    public void openPopupMenu() {
        String agreeButtonLocator = ".//button[contains(@class,\"web-layer_button-agree web-layer_button pts_string pts_agree-rules-button\")]";
        templateButton.click();
        WebElement scrollBar = driver.findElement(By.xpath(".//div[contains(@class,\"web-layer_content js-scroll-content\")]"));
        WebElement agreeButton = driver.findElement(By.xpath(agreeButtonLocator));
        scrollBar.click();
        try {
            Robot robot= new Robot();
            robot.keyPress(KeyEvent.VK_END);
            robot.keyRelease(KeyEvent.VK_END);
        } catch (Exception ignored) {}
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(agreeButton));
        agreeButton.click();
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(popupMenu.animalsButton));
    }

    public CreatedGiftsPage getCreatedGiftsPage() {
        String url = myCreatedGiftsButton.getAttribute("href");
        driver.navigate().to(url);
        return new CreatedGiftsPage(driver);
    }
}
