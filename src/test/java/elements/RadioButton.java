package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class RadioButton {
    private List<UIElement> uiElementsList;
    // продумать механизм поиска этого элемента
    //поиск по name
    public  RadioButton(WebDriver driver, String attributeNameValue){
        uiElementsList = new ArrayList<>();

        for (WebElement webElement : driver.findElements(By.name(attributeNameValue))){
            uiElementsList.add(new UIElement(driver, webElement));
        }
    }
    //добавить методы для работы с ним
    //selectBValue
    //selectByText
    //selectByIndex
    // проверить что поиск и методы работают на всех похожих элементах сайта
}
