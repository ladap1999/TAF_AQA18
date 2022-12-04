package tests;

import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParamDoubleTest extends BaseTest {
    @Parameters({"firstNumber", "secondNumber"})
    @Test
    public void validOneNegativeDoubleTest(@Optional("20.5") String firstNumber,
                                           @Optional("5.5") String secondNumber) {
        double num1 = Double.parseDouble(firstNumber);
        double num2 = Double.parseDouble(secondNumber);
        System.out.println("FirstNumber is: " + num1);
        System.out.println("SecondNumber is: " + num2);
        double result = (double) num1 / num2;
        Assert.assertEquals(calculator.div(num1, num2), result);
    }
}
