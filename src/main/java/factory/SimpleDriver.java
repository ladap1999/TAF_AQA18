package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SimpleDriver {
    public WebDriver getDriver(){
        System.setProperty("webdriver.chrome.driver", "D:\\Tasks_IT_Academy\\GitHubRepos\\TAF_AQA18\\TAF_AQA18\\src\\test\\resources\\chromedriver.exe");
         return new ChromeDriver();
    }

}
