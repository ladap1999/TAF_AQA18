package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FrameTest extends BaseTest {
    @Test
    public void frameTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/iframe");

        WebElement frameElement = driver.findElement(By.xpath("//*[@title = 'Rich Text Area']"));
        driver.switchTo().frame(frameElement);

        Assert.assertEquals(waitsService.waitForExists(By.xpath("//p[text() = \"Your content goes here.\"]"))
                .getText(),"Your content goes here.");
        driver.switchTo().defaultContent();
    }
}
