import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GroupPageFactory {

    public static GroupPage getAutoMotoPage(WebDriver driver) throws LoginException {
        String groupPath = ".//a[@data-l=\"t,userAltGroup\"]";
        String autoCategory = ".//a[contains(@data-l,\"t,automoto\")]";

        UserPage userPage = new UserPage(driver, Literals.LOGIN, Literals.PASSWORD);

        userPage.driver.findElement(By.xpath(groupPath)).click();

        // Создаём объект класса WebDriverWait (оператор new), максимальное ожидание 3 секунды. Ожидание будет длиться до тех пор (until),
        // пока URL в адресной строке браузера не станет содержать в себе строку "profile". После этого выполнение программы продолжится.
        new WebDriverWait(driver, 3).until(ExpectedConditions.urlContains("profile"));

        // Найти элемент autoCategory и выполнить на нём действие click() (нажатие на элемент на страничке браузера)
        userPage.driver.findElement(By.xpath(autoCategory)).click();

        // Создаём объект класса WebDriverWait (оператор new), максимальное ожидание 3 секунды. Ожидание будет длиться до тех пор (until),
        // пока URL в адресной строке браузера не станет содержать в себе строку "automoto". После этого выполнение программы продолжится.
        new WebDriverWait(driver, 3).until(ExpectedConditions.urlContains("automoto"));

        return new GroupPage(userPage);
    }

}
