package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.data.StaticCalculatorProvider;

public class DataProviderCalculatorTests extends BaseTest {

    @Test(dataProvider = "testIntegerData", dataProviderClass = StaticCalculatorProvider.class)
    public void integerDivisionTest(int first, int second, double result) {
        double divisionResult = calculator.div(first, second);
        Assert.assertEquals(divisionResult, result);
    }

    @Test(dataProvider = "testDoubleData", dataProviderClass = StaticCalculatorProvider.class)
    public void doubleDivisionTest(double first, double second, double result) {
        double divisionResult = calculator.div(first, second);
        Assert.assertEquals(divisionResult, result);
    }
}
