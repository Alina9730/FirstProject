package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CategoryGroupPage extends PageObject {

    public CategoryGroupPage(WebDriver driver) {
        super(driver);
    }

    @FindAll({@FindBy(xpath = ".//div[contains(@data-l,\"groupId\")]")})
    public List<WebElement> groupCards;
}
