package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Path;

public class FileUploadTest extends BaseTest {

    @Test
    public void fileUploadTest() {
        String pathToFile = "";
        driver.get("http://the-internet.herokuapp.com/upload");

        WebElement uploadWebElement = waitsService
                .waitForExists(By.xpath("//input[@type='file']"));

        try {
            pathToFile = FileUploadTest.class.getClassLoader().getResource("cable.png").getPath();
            uploadWebElement.sendKeys(pathToFile);
        } catch (InvalidArgumentException exception) {
            pathToFile = FileUploadTest.class.getClassLoader().getResource("cable.png").getPath().substring(1);
            uploadWebElement.sendKeys(pathToFile);
        }

        driver.findElement(By.id("file-submit")).submit();

        Assert.assertEquals(waitsService.waitsForVisibilityBy(By.id("uploaded-files"))
                .getText().trim(), "cable.png");
    }
}
