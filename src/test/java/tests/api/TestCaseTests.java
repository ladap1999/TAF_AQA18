package tests.api;

import baseEntities.BaseApiGsonTest;
import models.CasesToMove;
import models.TestCase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCaseTests extends BaseApiGsonTest {
    private TestCase actualTestCase;

    @Test
    public void getTestCase() {
        actualTestCase = testCaseAdapter.get(testCaseAdapter.add(expectedTestCase).getId());
        Assert.assertEquals(actualTestCase, expectedTestCase);
    }

    @Test(dependsOnMethods = "getTestCase")
    public void updateTestCase() {
        actualTestCase.setTitle("UpdatedTestCase");
        Assert.assertEquals(
                testCaseAdapter.update(actualTestCase), actualTestCase);
    }

    @Test(dependsOnMethods = "updateTestCase")
    public void moveTestCase() {
        CasesToMove casesToMove = CasesToMove
                .builder()
                .caseIds(new int[]{actualTestCase.getId()})
                .build();

        testCaseAdapter.move(casesToMove);
    }

    @Test(dependsOnMethods = "moveTestCase")
    public void deleteMTestCase() {
        testCaseAdapter.delete(actualTestCase);
    }
}
