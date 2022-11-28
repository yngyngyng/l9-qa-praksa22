package runners.LoginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import Pages.LoginPage;

public class LoginTests {
    final static String loginPageUrl = "https://saucedemo.com";
    WebDriver driver = new ChromeDriver();
    LoginPage loginPage = new LoginPage(driver);

    @BeforeClass
    public void setupClass() {
        String loginPage = loginPageUrl;
        driver.get(loginPage);
    }

    @BeforeMethod
    public void refreshPage() {
        driver.get(loginPageUrl);
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }

    @Test
    public void loginStandardUser() {
        loginPage.loginToSauceDemo("standard_user","secret_sauce");
        loginPage.checkUserIsLoggedIn();
    }

    @Test
    public void loginStandardUserWithWrongPassword() {
        loginPage.loginToSauceDemo("standard_user","hot_secret_sauce");
        loginPage.checkLoginFailed();
    }

    @Test
    public void loginLockedOutUser() {
        loginPage.loginToSauceDemo("locked_out_user", "secret_sauce");
        loginPage.checkLoginFailed();
    }
}
