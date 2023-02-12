package tests.api;

import baseEntities.BaseApiGsonTest;
import configuration.ReadProperties;
import io.restassured.response.Response;
import models.Milestone;
import models.MilestonesResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import utils.Endpoints;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;

public class MilestoneTests extends BaseApiGsonTest {
    private Milestone actualMilestone;

    @Test
    public void getMilestones() {
        Milestone expectedMilestone = Milestone.builder()
                .id(15)
                .name("ForGetting")
                .build();
        Response response = given()
                .pathParams("project_id", ReadProperties.getProjectId())
                .when()
                .get(Endpoints.GET_MILESTONES)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();

        MilestonesResponse actualMilestoneResponse = gson.fromJson(response.getBody().asPrettyString(),
                MilestonesResponse.class);
        for (Milestone element : actualMilestoneResponse.getMilestones()) {
            if (element.getId() == expectedMilestone.getId()) {
                assertThat(element, equalTo(expectedMilestone));
            }
        }
    }

    @Test
    public void addMilestone() {
        actualMilestone = milestoneAdapter.add(expectedMilestone);
    }

    @Test(dependsOnMethods = "addMilestone")
    public void updateMilestone() {
        actualMilestone.setDescription("Update_description");
        milestoneAdapter.update(actualMilestone);
    }

    @Test(dependsOnMethods = "updateMilestone")
    public void deleteMilestone() {
        milestoneAdapter.delete(actualMilestone);
    }
}
