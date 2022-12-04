package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;
import utils.Retry;

public class RetryTest extends BaseTest {
    private int attempt = 1;

    @Test(retryAnalyzer = Retry.class)
    public void flakyTest() {
        if (attempt == 3) {
            Assert.assertEquals(calculator.div(12, 2), 6);
        } else {
            attempt++;
            System.out.println("Attempt is: " + attempt);
            Assert.assertEquals(calculator.div(12, 2), 8);
        }
    }
}
