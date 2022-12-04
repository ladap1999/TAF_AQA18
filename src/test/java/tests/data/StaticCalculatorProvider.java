package tests.data;

import org.testng.annotations.DataProvider;

public class StaticCalculatorProvider {

    @DataProvider(name = "testIntegerData")
    public static Object[][] testIntegerData(){
        return  new Object[][]{
                {-6, -3, 2},
                {-10, 2, -5},
                {30, -10, -3},
                //Next tests will be failed in runtime, because int has specific behavior in case of double result
                {Integer.MIN_VALUE, 10000, -214748.3648},
                {Integer.MAX_VALUE,Integer.MIN_VALUE,-0.9999999995343387},
                {2000000000, Integer.MAX_VALUE, 0.9313225750491594}
        };
    }

    @DataProvider(name = "testDoubleData")
    public static Object[][] testDoubleData(){
        return  new Object[][]{
                {30.1, -0.1, -301},
                {0.0, 2.0, 0.0},
                {Double.MAX_VALUE, 2000000.0, 8.98846567431158E301},
                {-Double.MAX_VALUE,Double.MIN_VALUE,Double.NEGATIVE_INFINITY},
                {2000.0, Double.MAX_VALUE, 1.1125369292536008E-305}
        };
    }
}
