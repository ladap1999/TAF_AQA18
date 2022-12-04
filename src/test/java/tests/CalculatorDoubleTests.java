package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorDoubleTests extends BaseTest {

    //Test will be failed in runtime, because double has specific behavior with division by zero,
    // but calculator must have message error
    @Test(testName = "double value divide by zero", expectedExceptions = ArithmeticException.class, priority = 0)
    public void doubleDivideByZeroTest() {
        Assert.assertEquals(calculator.div(15.5, 0.0), Double.POSITIVE_INFINITY);
    }

    @Test(priority = 1, alwaysRun = true)
    public void divisionWithDoubleValidDataTest() {
        Assert.assertEquals(calculator.div(3.6, 2.0), 1.8);
    }

    @Test(dependsOnMethods = "divisionWithDoubleValidDataTest", priority = 2)
    public void divisionWithDoubleNegativeValidDataTest() {
        Assert.assertEquals(calculator.div(-6.0, -0.3), 20);
    }
}
