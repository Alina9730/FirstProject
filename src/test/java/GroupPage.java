import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GroupPage {
    WebDriver driver;

    public GroupPage(WebDriver driver) {
        this.driver = driver;
    }

//    public boolean isAllAvatarsDisplayed() {
//        String imageLocator = ".//img[contains(@class, \"photo_img\")]";
//        // Инициализация списка avatarLocators (так как мы нах-ся в одном классе, то вызывать метод можно без переменной (не используя точку)
//        List<GroupCard> avatarCards = getAvatarCards();
//
//        for (GroupCard card : avatarCards) {
//            WebElement image = card.element.findElement(By.xpath(imageLocator));
//            if (!image.isDisplayed()) {
//                return false;
//            }
//        }
//        return !avatarCards.isEmpty();
//    }

    public List<WebElement> getAvatars() {
        String groupLocator = ".//div[contains(@data-l,\"groupId\")]";

        return driver.findElements(By.xpath(groupLocator));
    }
}