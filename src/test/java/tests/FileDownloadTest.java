package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class FileDownloadTest extends BaseTest {

    @Test
    public void fileDownloadTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/download");

        WebElement link = driver.findElement(By.xpath("//a[@href = 'download/sample.png']"));
        link.click();

        String nameFile = link.getText();
        Assert.assertTrue(waitsService.waitForExistsFile(System.getProperty("user.dir")
                + File.separator + nameFile));
    }
}
