package pages.project;

import baseEntities.BasePage;
import elements.Checkbox;
import elements.UIElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TodoPage extends BasePage {
    private final static String pagePath = "index.php?/todos/overview/2";
    private final static By filterLinkLocator = By.id("filterByEmpty");

    private final static String checkboxName = "statusSelection[]";

    public TodoPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return null;
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    public UIElement getFilterLink() {
        return new UIElement(driver,filterLinkLocator);
    }

    public Checkbox getType() {
        return new Checkbox(driver, checkboxName);
    }
}
