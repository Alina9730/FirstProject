import exceptions.LoginException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class GroupPage {

    public static List<WebElement> getAvatars(WebDriver driver) {
        String groupLocator = ".//div[contains(@data-l,\"groupId\")]";

        return driver.findElements(By.xpath(groupLocator));
    }

    public static void goToAutoMotoPage(WebDriver driver) throws LoginException {
        String groupButton = ".//a[@data-l=\"t,userAltGroup\"]";
        String autoMotoButton = ".//a[contains(@data-l,\"t,automoto\")]";

        UserPage.goToUserPage(driver, Literals.LOGIN, Literals.PASSWORD);

        // Нажать кнопку с локатором `groupButton`, подождать пока URL в адресной строке браузера не станет содержать в себе строку "profile"
        // Максимальное ожидание - 3 секунды. После выполнения условия продолжить.
        Utils.pressButtonAndWaitForCondition(driver, groupButton, 3, ExpectedConditions.urlContains("profile"));

        // Нажать кнопку с локатором `autoMotoButton`, подождать пока URL в адресной строке браузера не станет содержать в себе строку "automoto"
        // Максимальное ожидание - 3 секунды. После выполнения условия продолжить.
        Utils.pressButtonAndWaitForCondition(driver, autoMotoButton, 3, ExpectedConditions.urlContains("automoto"));
    }
}