package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Checkbox {
    private UIElement uiElement;
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
        UIElement selectedUIElement = uiElementList.get(textList.indexOf(text));
        return selectedUIElement.isSelected();
    }
    public UIElement clickByText(String text,boolean flag) {
        UIElement selectedUIElement = uiElementList.get(textList.indexOf(text));
        if(flag != selectedUIElement.isSelected()){
        selectedUIElement.click();
        return selectedUIElement;
    }

    private void click(boolean flag) {
        if (flag != uiElement.isSelected()) {
            uiElement.click();
        }
    }

    public void setFlag() {
        click(true);
    }

    public void removeFlag() {
        click(false);
    }

    public UIElement selectByIndex(int index) {
        UIElement selectedUIElement = uiElementList.get(index);
        selectedUIElement.click();
        return selectedUIElement;
    }
}

