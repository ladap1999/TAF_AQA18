package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Checkbox {
    private List<UIElement> uiElementList;
    private List<String> textList;

    public Checkbox(WebDriver driver, String attributeNameValue) {
        uiElementList = new ArrayList<>();
        textList = new ArrayList<>();

        for (WebElement webElement : driver.findElements(By.name(attributeNameValue))) {
            UIElement element = new UIElement(driver, webElement);
            uiElementList.add(element);
            textList.add(element.findUIElement(By.xpath("parent::*/span")).getText().trim());
        }
    }

    public boolean isSelected(String text) {
        UIElement selectedUIElement = getElement(text);
        return selectedUIElement.isSelected();
    }

    public UIElement setFlag(String checkboxName) {
        if (!isSelected(checkboxName)) {
            click(checkboxName);
        }
        return getElement(checkboxName);
    }

    public UIElement removeFlag(String checkboxName) {
        if (isSelected(checkboxName)) {
            click(checkboxName);
        }
        return getElement(checkboxName);
    }

    public void click(String checkboxName) {
        getElement(checkboxName).click();
    }

    public UIElement getElement(String checkboxName) {
        UIElement selectedElement = uiElementList.get(textList.indexOf(checkboxName));
        return selectedElement;
    }
}


