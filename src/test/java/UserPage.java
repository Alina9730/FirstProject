import org.openqa.selenium.WebDriver;

public class UserPage {
    // То же самое что и в LoginPage
    public final WebDriver driver;

    UserPage(WebDriver driver, String login, String pass) throws LoginException {
        driver.get("https://ok.ru/");
        // Странно, что мы проверяем возможность зайти в UserPage, может стоит делать это в LoginPage?
        if (LoginPage.isLoggedIn(driver)) {
            this.driver = driver;
        } else {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.doLogin(login, pass);
            if (LoginPage.isLoggedIn(driver)) {
                this.driver = driver;
            } else {
                throw new LoginException("Incorrect login or password!");
            }
        }
    }
}