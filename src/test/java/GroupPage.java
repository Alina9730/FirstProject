import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class GroupPage {
    WebDriver driver;

    public GroupPage(UserPage userPage) {
        this.driver = userPage.driver;
    }

    public boolean isAllAvatarsDisplayed() {
        String imageLocator = ".//img[contains(@class, \"photo_img\")]";
        // Инициализация списка avatarLocators (так как мы нах-ся в одном классе, то вызывать метод можно без переменной (не используя точку)
        List<GroupCard> avatarCards = getAvatarCards();
        //System.out.println(avatarCards.size());

        if (avatarCards.size() > 0) {
            for (GroupCard card : avatarCards) {
                WebElement image = card.element.findElement(By.xpath(imageLocator));
                if (!image.isDisplayed()) {
                    return false;
                }
            }
            return true;
        }
        else {
            return false;
        }
    }

    private List<GroupCard> getAvatarCards() {
        String groupLocator = ".//div[contains(@data-l,\"groupId\")]";

        List<GroupCard> avatarCards = new ArrayList<>();
        List<WebElement> rawCards = driver.findElements(By.xpath(groupLocator));

        for (WebElement element : rawCards) {
            GroupCard groupCard = new GroupCard (element);
            avatarCards.add(groupCard);
        }
        return avatarCards;
    }
}