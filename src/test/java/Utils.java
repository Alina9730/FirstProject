import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static List<WebElement> getWebElementsList(WebDriver driver, List<String> locators) {
        List<WebElement> elements = new ArrayList<>();
        for (String locator : locators) {
            WebElement element = driver.findElement(By.xpath(locator));
            elements.add(element);
        }
        return elements;
    }

    public static void pressButton(WebDriver driver, String locator) {
        driver.findElement(By.xpath(locator)).click();
    }
}
