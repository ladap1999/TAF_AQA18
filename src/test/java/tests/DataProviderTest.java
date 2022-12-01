package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.data.StaticProvider;

public class DataProviderTest {
    Calculator calculator = new Calculator();

    @Test(dataProvider = "dataForSome", dataProviderClass = StaticProvider.class, threadPoolSize = 2)
    public void testSum(int a, int b, int expected){
        Assert.assertEquals(calculator.sum(2,3),5, "Неверная сумма...");
    }
}
