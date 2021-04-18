import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class GroupPage {
    // Для каждого объекта свой драйвер?
    WebDriver driver;

    public GroupPage(UserPage userPage) {
        this.driver = userPage.driver;
    }

    public boolean isAllAvatarsDisplayed() {
        // Сделать константу было бы удобнее
        String imageLocator = ".//img[contains(@class, \"photo_img\")]";
        // Инициализация списка avatarLocators (так как мы нах-ся в одном классе, то вызывать метод можно без переменной (не используя точку)
        List<GroupCard> avatarCards = getAvatarCards();
        //System.out.println(avatarCards.size());
        /*
            Для чего нужна проверка, если лист пустой, то мы просто выйдем из фора,
            но если сильно хочется, то у листа есть метод isEmpty()
         */
        if (avatarCards.size() > 0) {
            for (GroupCard card : avatarCards) {
                // Можно было не объявлять лишнюю переменную и вызвать isDisplayed() сразу в if
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
        // Сделать константу было бы удобнее
        String groupLocator = ".//div[contains(@data-l,\"groupId\")]";

        List<GroupCard> avatarCards = new ArrayList<>();
        List<WebElement> rawCards = driver.findElements(By.xpath(groupLocator));
        /*
            Для чего нужен класс обертки, если там есть только WebElement,
            к которому мы можем обратиться и через список rawCards?
            Наверное стоило добавить туда что-нибудь еще, например метод поиска элемента
         */
        for (WebElement element : rawCards) {
            GroupCard groupCard = new GroupCard (element);
            avatarCards.add(groupCard);
        }
        return avatarCards;
    }
}