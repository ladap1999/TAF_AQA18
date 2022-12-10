package tests;

import configuration.ReadProperties;
import factory.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SwagLabsTests {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new BrowserFactory().getDriver();
    }

    @Test
    public void addItemToTheCartTest() throws InterruptedException {
        //Navigate to the website
        driver.get(ReadProperties.getUrl());

        //Login
        WebElement userName = driver.findElement(By.cssSelector(".input_error.form_input"));
        userName.sendKeys(driver.findElement(By.xpath("//*[@id = 'login_credentials']")).getText().split("\n")[1]);

        WebElement password = driver.findElement(By.cssSelector("[type^='pass']"));
        password.sendKeys(driver.findElement(By.xpath("//*[@class = 'login_password']")).getText().split("\n")[1]);

        Assert.assertTrue(driver.findElement(By.cssSelector(".form_column .login-box")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("login_credentials")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.tagName("form")).isDisplayed());

        driver.findElement(By.className("submit-button")).click();

        Thread.sleep(3000);

        //All items
        Assert.assertTrue(driver.findElement(By.cssSelector("footer")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("ul.social")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector(".peek")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-fleece-jacket")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.partialLinkText("Bike Light")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.name("add-to-cart-sauce-labs-bike-light")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//select/parent::*")).isDisplayed());
        driver.findElement(By.xpath("//*[text()='Name (A to Z)']//ancestor::select")).click();
        driver.findElement(By.xpath("//option[contains(@value,'ohi')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='All Items']")).isDisplayed());

        driver.findElement(By.linkText("Sauce Labs Backpack")).click();

        //Item details
        Assert.assertTrue(driver.findElement(By.cssSelector("[name|='back']")).isDisplayed());

        driver.findElement(By.xpath("//div[@class='left_component']/following::button")).click();
        driver.findElement(By.xpath("//div[@class='header_secondary_container']/preceding::a[@class = 'shopping_cart_link']")).click();

        //The cart
        Assert.assertTrue(driver.findElement(By.cssSelector("[id = 'remove-sauce-labs-backpack']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("[href$='twitter.com/saucelabs']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//button[@data-test='continue-shopping' and @name='continue-shopping']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("[class~='btn_action']")).isDisplayed());

        Assert.assertEquals(driver.findElement(By.xpath("//a/descendant::div")).getText(), "Sauce Labs Backpack");
        Assert.assertEquals(driver.findElement(By.cssSelector("[class*='_item_price']")).getText(), "$29.99");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
