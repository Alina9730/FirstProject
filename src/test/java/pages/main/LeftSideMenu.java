package pages.main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import components.CustomButton;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import java.util.List;

@FindBy(xpath = ".//div[contains(@class,\"nav-side __navigation __user-main\")]")
public class LeftSideMenu extends HtmlElement {
    public static long INITIAL_MENU_SIZE = 15;
    public static long ADDITIONAL_MENU_SIZE = 8;

    @FindAll({@FindBy(xpath = ".//a[contains(@class,\"nav-side\")]")})
    public List<WebElement> items;

    @FindBy(xpath = ".//div[contains(@data-l,\"t,toggler\")]")
    public CustomButton togglerButton;

    @FindBy(xpath = ".//a[@data-l=\"t,userAltGroup\"]")
    public CustomButton groupsButton;

    @FindBy(xpath = ".//a[@data-l=\"t,giftsFront\"]")
    public CustomButton giftsButton;

    @FindBy(xpath = ".//a[contains(@data-l,\"t,userStatuses\")]")
    public CustomButton notesButton;

    public long getVisibleItemsSize() {
       return items.stream().filter(WebElement::isDisplayed).count();
    }

    public void pressTogglerButton(WebDriver driver, long sleepTimeMillis) {
        togglerButton.clickAndWait(sleepTimeMillis);
        items = driver.findElements(By.xpath(".//a[contains(@class,\"nav-side\")]"));
    }
}
