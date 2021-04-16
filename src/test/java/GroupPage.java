import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class GroupPage {
    int size;
    WebDriver driver;
    WebElement image;

    private static final By autoCategory = By.xpath(".//a[contains(@data-l,\"t,automoto\")]");
    private static final By groupLocator = By.xpath(".//div[contains(@data-l,\"groupId\")]");
    private static final By imageLocator = By.xpath(".//img[contains(@class, \"photo_img\")]");


    String autoMotoUrl = "https://ok.ru/groups/automoto";
    List<GroupCard> avatarCards = new ArrayList<>();


    public GroupPage(WebDriver driver) {
        this.driver = driver;
    }

    public void checkCategory() {
        // Найти элемент autoCategory и выполнить на нём действие click() (нажатие на элемент на страничке браузера)
        driver.findElement(autoCategory).click();
        // Создаём объект класса WebDriverWait (оператор new), максимальное ожидание 3 секунды. Ожидание будет длиться до тех пор (until),
        // пока URL в адресной строке браузера не станет равным autoMotoUrl. После этого выполнение программы продолжится.
        new WebDriverWait(driver, 3).until(ExpectedConditions.urlToBe(autoMotoUrl));
        // Инициализация списка avatarLocators (так как мы нах-ся в одном классе, то вызывать метод можно без переменной (не используя точку)
        getAvatarLocators();
        //System.out.println(avatarCards.size());

        if (avatarCards.size() > 0) {
            for (GroupCard card : avatarCards) {
                image = card.element.findElement(imageLocator);
                if (image.isDisplayed()) {
                    System.out.println(image.toString());
                } else {
                    System.out.println("element not found");
                }
            }
        }
    }



    public void setSize() {
        size = driver.findElements(groupLocator).size();
    }

    public void getAvatarLocators() {
        List<WebElement> rawCards = driver.findElements(groupLocator);
        for (WebElement element : rawCards) {
            GroupCard groupCard = new GroupCard (element);
            avatarCards.add(groupCard);
        }
    }
}