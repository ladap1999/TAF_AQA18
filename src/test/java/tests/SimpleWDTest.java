package tests;

import factory.AdvancedDriver;
import factory.BrowserFactory;
import factory.SimpleDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.text.BreakIterator;

public class SimpleWDTest {
@Test
    public void simpleWDTest(){
    SimpleDriver simpleDriver  = new SimpleDriver();
    WebDriver driver = simpleDriver.getDriver();
    driver.quit();
}

    @Test
    public void advancedWDTest(){
        AdvancedDriver advancedDriver  = new AdvancedDriver();
        WebDriver driver = advancedDriver.getDriver();
        driver.quit();
    }

    @Test
    public void brawserFactoryWDTest(){
        BrowserFactory brawserFactor = new BrowserFactory();
        WebDriver driver = brawserFactor.getDriver();
        driver.quit();
    }


}
