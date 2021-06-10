package pages.main.notes;

import components.CustomButton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageObject;
import pages.main.MainPage;

public class NotesPage extends PageObject {
    public NotesPage (WebDriver driver) {super(driver);}

    @FindBy(xpath = ".//div[contains(@class,\"posting_itx emoji-tx h-mod js-ok-e js-posting-itx ok-posting-handler\")]")
    public WebElement textField;

    @FindBy(xpath = ".//div[contains(@data-l,\"t,button.submit\")]")
    public CustomButton shareButton;

    public MainPage doNote(String note){
        textField.sendKeys(note);
        shareButton.clickAndWait(100);
        driver.navigate().refresh();
        return new MainPage(driver);
    }

}
