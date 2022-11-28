package runners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DefaultTests {
    WebDriver driver = new ChromeDriver();

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
    public void firstTest() {
        Assert.assertEquals(driver.getTitle(), "Swag Labs");
    }



    @Test
    public void loginTest() {
        WebElement username = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.name("login-button"));

        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        loginButton.click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }

    @Test
    public void addItemToCart() {
        loginTest();
        WebElement addToCart = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        addToCart.click();
        WebElement shoppingCartBadge = driver.findElement(By.className("shopping_cart_badge"));
        Assert.assertEquals(shoppingCartBadge.getText(), "1");
    }

    @Test
    public void removeItemFromCart() {
        addItemToCart();
        WebElement removeItemFromCart = driver.findElement(By.id("remove-sauce-labs-backpack"));
        removeItemFromCart.click();
        By shoppingCartBadge = By.className("shopping_cart_badge");
        Assert.assertFalse(driver.findElement(shoppingCartBadge).isDisplayed());
    }
}
