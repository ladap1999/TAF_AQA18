package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContextMenuTest extends BaseTest {

    @Test
    public void contextMenuTest() {
        driver.get("http://the-internet.herokuapp.com/context_menu");

        WebElement area = driver.findElement(By.id("hot-spot"));

        Actions actions = new Actions(driver);
        actions.moveToElement(area, 20, 20).contextClick().build().perform();

        Alert alert = driver.switchTo().alert();

        Assert.assertEquals(alert.getText(), "You selected a context menu");

        alert.accept();

        Assert.assertEquals(driver.findElement(By.xpath("//h3")).getText(), "Context Menu");
    }

}
