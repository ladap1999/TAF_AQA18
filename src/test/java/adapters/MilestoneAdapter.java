package adapters;

import configuration.ReadProperties;
import io.restassured.mapper.ObjectMapperType;
import models.Milestone;
import org.apache.http.HttpStatus;
import utils.Endpoints;

import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;


public class MilestoneAdapter extends BaseAdapter {
    public Milestone add(Milestone milestone) {
        String jsonBody = getGson().toJson(milestone);

        return post(
                jsonBody,
                Endpoints.ADD_MILESTONE,
                "project_id",
                ReadProperties.getProjectId(),
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

    public Milestone post(String jsonBody, String endpoint, String pathParam, int id, Milestone milestone) {
        return given()
                .pathParams(pathParam, id)
                .body(jsonBody)
                .log().all()
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .body("description", is(milestone.getDescription()))
                .body("name", is(milestone.getName()))
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(Milestone.class, ObjectMapperType.GSON);
    }
}
