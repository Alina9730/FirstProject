import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserPage {
    private final WebDriver driver;

    private UserPage(WebDriver driver){
        this.driver = driver;
    }

    UserPage(LoginPage loginPage, String login, String pass) throws LoginException {
        driver = loginPage.doLogin(login, pass);
        if (driver.findElements(By.xpath(".//a[contains(@data-l,\"t,userPage\")]")).isEmpty()) {
            throw new LoginException("Incorrect login or password!");
        } else {
            new UserPage(driver);
        }
    }

    public GroupPage moveToGroups() {
        String groupPath = ".//a[@data-l=\"t,userAltGroup\"]";
        driver.findElement(By.xpath(groupPath)).click();
        return new GroupPage(driver);
    }
}