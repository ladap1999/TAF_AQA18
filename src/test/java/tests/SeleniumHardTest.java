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

public class SeleniumHardTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        BrowserFactory browserFactory = new BrowserFactory();
        driver = browserFactory.getDriver();
    }

    @Test
    public void calcLaminate() throws InterruptedException {
        driver.get("https://calc.by/building-calculators/laminate.html");
        Thread.sleep(5000);
        Select selectMethodOfLaying = new Select(driver.findElement(By.id("laying_method_laminate")));
        selectMethodOfLaying.selectByIndex(2);

        WebElement length = driver.findElement(By.id("ln_room_id"));
        length.clear();
        Thread.sleep(1000);
        length.sendKeys("500");

        WebElement width = driver.findElement(By.id("wd_room_id"));
        width.clear();
        Thread.sleep(1000);
        width.sendKeys("400");

        WebElement panelLength = driver.findElement(By.id("ln_lam_id"));
        panelLength.clear();
        Thread.sleep(1000);
        panelLength.sendKeys("2000");

        WebElement panelWidth = driver.findElement(By.id("wd_lam_id"));
        panelWidth.clear();
        Thread.sleep(1000);
        panelWidth.sendKeys("200");

        WebElement radioButton = driver.findElement(By.id("direction-laminate-id1"));
        radioButton.click();
        Thread.sleep(1000);

        WebElement calcButton = driver.findElement(By.className("calc-btn"));
        calcButton.click();
        Thread.sleep(5000);
        String firstResultString = driver.findElement(By.xpath("//*[text() = 'Требуемое количество досок ламината: ']")).getAttribute("innerText");
        String secondResultString = driver.findElement(By.xpath("//*[text() = 'Количество упаковок ламината: ']")).getAttribute("innerText");

        Assert.assertEquals(firstResultString, "Требуемое количество досок ламината: 53");
        Assert.assertEquals(secondResultString, "Количество упаковок ламината: 7");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
