package tests;

import factory.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumLightTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        BrowserFactory browserFactory = new BrowserFactory();
        driver = browserFactory.getDriver();
    }

    @Test
    public void validElectroFloorCalculator() throws InterruptedException {
        driver.get("https://kermi-fko.ru/raschety/Calc-Rehau-Solelec.aspx");
        driver.findElement(By.id("el_f_width")).sendKeys("3");
        driver.findElement(By.id("el_f_lenght")).sendKeys("4");

        Select selectRoom = new Select(driver.findElement(By.id("room_type")));
        selectRoom.selectByIndex(3);

        Select selectTypeHeating = new Select(driver.findElement(By.id("heating_type")));
        selectTypeHeating.selectByIndex(1);

        driver.findElement(By.id("el_f_losses")).sendKeys("185");

        WebElement calcButton = driver.findElement(By.name("button"));
        Thread.sleep(3000);
        calcButton.click();

        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.id("floor_cable_power")).getAttribute("value"), "194");

        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.id("spec_floor_cable_power")).getAttribute("value"), "16");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
