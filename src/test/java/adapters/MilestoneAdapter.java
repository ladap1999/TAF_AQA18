package adapters;

import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import models.Milestone;
import org.apache.http.HttpStatus;
import utils.Endpoints;

import static io.restassured.RestAssured.given;

public class MilestoneAdapter extends BaseAdapter {

    public Response getMilestones(int projectID) {
        return given()
                .pathParams("project_id", projectID)
                .when()
                .get(Endpoints.GET_MILESTONES)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();
    }

    public Milestone add(Milestone milestone, int projectID) {
        return post(
                getGson().toJson(milestone),
                Endpoints.ADD_MILESTONE,
                "project_id",
                projectID,
                milestone);
    }

    public Milestone update(Milestone milestone) {
        String jsonBody = getGson().toJson(milestone);

        return post(
                jsonBody,
                Endpoints.UPDATE_MILESTONE,
                "milestone_id",
                milestone.getId(),
                milestone);
    }

    public void delete(Milestone milestone) {
        given()
                .pathParams("milestone_id", milestone.getId())
                .when()
                .post(Endpoints.DELETE_MILESTONE)
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

    public Milestone post(String jsonBody, String endpoint, String pathParam, int pathValue, Milestone milestone) {
        return given()
                .pathParams(pathParam, pathValue)
                .body(jsonBody)
                .log().all()
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(Milestone.class, ObjectMapperType.GSON);
    }
}
