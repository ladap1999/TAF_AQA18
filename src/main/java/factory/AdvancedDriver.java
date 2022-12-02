package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AdvancedDriver {

    public WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "D:\\Tasks_IT_Academy\\GitHubRepos\\TAF_AQA18\\TAF_AQA18\\src\\test\\resources\\chromedriver.exe");

        return new ChromeDriver(getChromeOptions());
    }

    public ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(false);
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--ignore-certificate-errors");
        chromeOptions.addArguments("--silent");
        chromeOptions.addArguments("--start-maximized");

        return chromeOptions;
    }
}
