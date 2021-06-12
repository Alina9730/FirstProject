package pages.main.gifts.constructor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import components.CustomButton;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import java.util.List;
import java.util.stream.Collectors;


@FindBy(xpath = ".//div[contains(@id,\"id-album_layer\")]")
public class PopupMenu extends HtmlElement {

    @FindBy(xpath = ".//div[contains(@data-album-id,\"template_albumanimals\")]")
    public CustomButton animalsButton;

    public List<CustomButton> getGiftsCards(WebDriver driver) {
         return driver
                 .findElements(By.xpath(".//div[contains(@data-photo-type,\"template\")]"))
                 .stream().map(CustomButton::new).collect(Collectors.toList());
    }
}
