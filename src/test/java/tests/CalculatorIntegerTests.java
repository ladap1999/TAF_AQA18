package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorIntegerTests extends BaseTest {

    @Test(groups = "Smoke", description = "with valid data", timeOut = 1000)
    public void divisionWithIntegerValidDataTest() {
        Assert.assertEquals(calculator.div(15, 3), 5, "Incorrect data");
    }

    @Test(groups = "Smoke", enabled = false)
    public void disabledTest() {
        Assert.assertEquals(calculator.div(-20, 10), -2);
    }

    @Test(groups = "Regression", testName = "0 divide by number", invocationCount = 2, invocationTimeOut = 500, threadPoolSize = 2)
    public void zeroDivideByNumberTest() throws InterruptedException {
        Thread.sleep(100);
        Assert.assertEquals(calculator.div(0, 10), 0);
    }

    @Test(groups = "Regression", testName = "divide by zero", expectedExceptions = ArithmeticException.class)
    public void integerExceptionTest() {
        Assert.assertEquals(calculator.div(18, 0), Double.POSITIVE_INFINITY);
    }
}
