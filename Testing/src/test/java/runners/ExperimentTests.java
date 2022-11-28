package runners;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExperimentTests {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        this.driver = new ChromeDriver();
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

    @Test
    public void alertTests() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button")).click();
        driver.switchTo().alert().dismiss();
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button")).click();
        driver.switchTo().alert().accept();
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button")).click();
        Alert inputAlert = driver.switchTo().alert();
        inputAlert.sendKeys("Automated Alert!");
        inputAlert.accept();
    }

    @Test
    public void keyPressTest() {
        driver.get("https://the-internet.herokuapp.com/key_presses");
        WebElement targetElement = driver.findElement(By.id("target"));
        targetElement.click();
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_RIGHT).perform();
        Assert.assertEquals(driver.findElement(By.id("result")).getText(), "You entered: RIGHT", "Correct arrow key pressed.");
    }
}
