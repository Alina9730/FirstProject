package components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.element.Button;

public class CustomButton extends Button {
    public CustomButton(WebElement button) {
        super(button);
    }

    public void clickAndWait(long sleepTimeMillis) {
        super.click();
        try {
            if (sleepTimeMillis > 0) Thread.sleep(sleepTimeMillis);
        } catch (InterruptedException ex) {
            throw new WebDriverException(ex);
        }
    }

    public <T> void clickAndWaitForCondition(WebDriver driver, long sleepTimeSec, ExpectedCondition<T> condition) {
        super.click();
        new WebDriverWait(driver, sleepTimeSec).until(condition);
    }

    public <T> void clickAndWaitForCondition(WebDriver driver, ExpectedCondition<T> condition) {
        clickAndWaitForCondition(driver, 3, condition);
    }
}
