package services;

import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.List;

public class WaitsService {
    private WebDriver driver;
    private WebDriverWait wait;

    public WaitsService(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(ReadProperties.timeOut()));
    }

    public WaitsService(WebDriver driver, Duration timeout) {
        this.driver = driver;
        wait = new WebDriverWait(driver, timeout);
    }

    public WebElement waitsForVisibilityBy(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public boolean waitForInvisibilityBy(WebElement webElement) {
        return wait.until(ExpectedConditions.invisibilityOf(webElement));
    }

    public boolean waitForElementInvisible(WebElement webElement) {
        return wait.until(ExpectedConditions.invisibilityOf(webElement));
    }

    public WebElement fluentWaitForElement(By by) {
        Wait<WebDriver> fluent = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(50)).ignoring(NoSuchElementException.class);

        return fluent.until(driver -> driver.findElement(by));
    }

    public List<WebElement> waitForAllVisibleElementsLocatedBy(By locator) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public WebElement waitForExists(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public boolean waitForExistsFile(String filePath) throws InterruptedException {
        File file = new File(filePath);
        int count = 0;

        while (!file.exists() && count < 5) {
            Thread.sleep(2000);
            count++;
        }

        if (count == 5 && !file.exists()) {
            return false;
        } else {
            return true;
        }
    }
}
