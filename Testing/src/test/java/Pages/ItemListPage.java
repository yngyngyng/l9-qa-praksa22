package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ItemListPage {
    WebDriver driver;
    By addItem1Button = By.id("add-to-cart-sauce-labs-backpack");
    By addItem2Button = By.id("add-to-cart-sauce-labs-bike-light");
    By removeItemButton = By.id("remove-sauce-labs-backpack");
    By shoppingCartBadge = By.className("shopping_cart_badge");
    public ItemListPage(WebDriver driver){this.driver = driver;}
    public void addItemButton(){
        driver.findElement(addItem1Button).click();
    }
    public void addSecondItem(){
        driver.findElement(addItem2Button).click();
    }
    public void removeItem(){
        driver.findElement(removeItemButton).click();
    }
    public void checkItemAdded(){
        WebElement cartBadge = driver.findElement(shoppingCartBadge);
        Assert.assertEquals(cartBadge,driver.findElement(shoppingCartBadge));
    }

    public void openCartPage() {
        driver.findElement(shoppingCartBadge).click();
    }
    public void checkMultipleItems(){
        WebElement cartBadge = driver.findElement(By.className("shopping_cart_badge"));
        Assert.assertEquals(cartBadge.getText(),"2");
    }
    public void checkItemRemoved(){
        boolean badge = driver.findElements(By.className("shopping_cart_badge")).size() !=0;
        Assert.assertEquals(false,badge);

    }
}
