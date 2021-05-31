package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    public static void pressButton(WebDriver driver, String buttonLocator) {
        try {
            pressButtonAndWait(driver, buttonLocator, 0);
        } catch (Exception ignored) {}
    }

    public static void pressButtonAndWait(WebDriver driver, String buttonLocator, long sleepTimeMillis) throws InterruptedException {
        driver.findElement(By.xpath(buttonLocator)).click();
        if (sleepTimeMillis > 0) Thread.sleep(sleepTimeMillis);
    }

    public static <T> void pressButtonAndWaitForCondition(WebDriver driver, String buttonLocator, long sleepTimeSec, ExpectedCondition<T> condition) {
        driver.findElement(By.xpath(buttonLocator)).click();
        new WebDriverWait(driver, sleepTimeSec).until(condition);
    }

}
