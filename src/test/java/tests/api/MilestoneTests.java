package tests.api;

import baseEntities.BaseApiTest;
import io.restassured.response.Response;
import models.Milestone;
import models.MilestonesResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class MilestoneTests extends BaseApiTest {
    private Milestone actualMilestone;


    @Test
    public void getMilestones() {
        Response response = milestoneAdapter.getMilestones(projectID);

        MilestonesResponse actualMilestoneResponse = gson.fromJson(response.getBody().asPrettyString(),
                MilestonesResponse.class);

        Assert.assertTrue(actualMilestoneResponse.getMilestones() != null);

        for (Milestone element : actualMilestoneResponse.getMilestones()) {
            if (element.getDescription().equals(expectedMilestone.getDescription())) {
                assertThat(element, equalTo(expectedMilestoneFromDb));
            }
        }
    }

    @Test
    public void addMilestone() {
        actualMilestone = milestoneAdapter.add(expectedMilestoneFromDb, projectID);
        assertThat(actualMilestone.getName(), equalTo(expectedMilestoneFromDb.getName()));
    }

    @Test(dependsOnMethods = "addMilestone")
    public void updateMilestone() throws SQLException {
        ZonedDateTime startOfToday = LocalDate.now().atStartOfDay(ZoneId.systemDefault());
        long todayMillis = startOfToday.toEpochSecond() * 1000;

        String updatedName = "Update_milestone";
        milestoneTable.updateMilestoneName(expectedMilestone, updatedName);
        ResultSet resultSet = milestoneTable.getMilestoneByName(updatedName);
        resultSet.next();
        actualMilestone.setName(updatedName);
        actualMilestone.setStartDate(todayMillis);
        actualMilestone.setStartedOn(todayMillis);


        Assert.assertEquals(
                milestoneAdapter.update(actualMilestone).getName(),
                resultSet.getString("name"));
    }

    @Test(dependsOnMethods = "updateMilestone")
    public void deleteMilestone() throws SQLException {
        milestoneAdapter.delete(actualMilestone);

        milestoneTable.deleteMilestone("For_RestAPI");
        ResultSet resultSet = milestoneTable.getMilestoneByName("Update_milestone");

        Assert.assertFalse(resultSet.isBeforeFirst());
    }
}
