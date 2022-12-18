package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileDownloadTest extends BaseTest {

    @Test
    public void fileDownloadTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/download");

        WebElement link = driver.findElement(By.linkText("sample.png"));
        link.click();

        String nameFile = link.getText();
        Assert.assertTrue(waitsService.waitForExistsFile(ReadProperties.pathForDownload() + "\\" + nameFile));
    }
}
