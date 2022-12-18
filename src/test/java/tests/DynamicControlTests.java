package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicControlTests extends BaseTest {

    @Test(expectedExceptions = NoSuchElementException.class)
    public void dynamicControlRemoveAddTest() {
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");

        Assert.assertTrue(driver.findElement(By.id("checkbox")).isDisplayed());

        driver.findElement(By.xpath("//*[text() = 'Remove']")).click();
        waitsService.waitsForVisibilityBy(By.xpath("//*[text()=\"It's gone!\"]"));

        Assert.assertFalse(driver.findElement(By.id("checkbox")).isDisplayed());
    }

    @Test
    public void dynamicControlEnableDisableTest() {
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");

        Assert.assertFalse(driver.findElement(By.xpath("//*[@type='text']")).isEnabled());

        driver.findElement(By.xpath("//*[text() = 'Enable']")).click();
        waitsService.waitsForVisibilityBy(By.xpath("//*[text()=\"It's enabled!\"]"));

        Assert.assertTrue(driver.findElement(By.xpath("//*[@type='text']")).isEnabled());
    }
}
