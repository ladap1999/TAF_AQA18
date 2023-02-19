package adapters;

import models.Project;
import org.apache.hc.core5.http.HttpStatus;
import utils.Endpoints;

import static io.restassured.RestAssured.given;

public class ProjectAdapter extends BaseAdapter {

    public int addProject(Project expectedProject){

        return given()
                .body(getGson().toJson(expectedProject))
                .when()
                .post(Endpoints.ADD_PROJECT)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .jsonPath()
                .getInt("id");
    }

    public  void deleteProject(int projectID){
        given()
                .pathParam("project_id", projectID)
                .when()
                .post(Endpoints.DELETE_PROJECT)
                .then()
                .statusCode(HttpStatus.SC_OK);
    }
}
