package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    WebDriver driver;
    By checkoutButton = By.id("checkout");
    By continueShoppingButton = By.id("continue-shopping");
    By removeBackpackButton = By.id("remove-sauce-labs-backpack");
    By itemPrice = By.className("inventory_item_price");

    public CartPage(WebDriver driver){this.driver = driver;}

    public void continueCheckoutProcess() {
        driver.findElement(checkoutButton).click();
    }
}
