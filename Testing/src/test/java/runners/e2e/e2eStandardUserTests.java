package runners.e2e;

import Pages.CartPage;
import Pages.CheckoutPage;
import Pages.ItemListPage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class e2eStandardUserTests {
    WebDriver driver = new ChromeDriver();
    LoginPage loginPage = new LoginPage(driver);
    ItemListPage itemListPage = new ItemListPage(driver);
    CartPage cartPage = new CartPage(driver);
    CheckoutPage checkoutPage = new CheckoutPage(driver);

    @BeforeMethod
    public void setupClass() {
        String loginPage = "https://saucedemo.com";
        driver.get(loginPage);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void standardUserE2E() {
        loginPage.loginToSauceDemo("standard_user", "secret_sauce");
        loginPage.checkUserIsLoggedIn();
        itemListPage.addItemButton();
        itemListPage.checkItemAdded();
        itemListPage.openCartPage();
        cartPage.continueCheckoutProcess();
        checkoutPage.inputUserData("Ime", "Prezime", "5010TB");
        checkoutPage.clickContinueButton();
        checkoutPage.clickFinishOrderButton();
        checkoutPage.checkOrderIsCompleted();
    }
}
