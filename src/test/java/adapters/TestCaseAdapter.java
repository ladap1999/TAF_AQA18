package adapters;

import configuration.ReadProperties;
import io.restassured.mapper.ObjectMapperType;
import models.CasesToMove;
import models.TestCase;
import org.apache.http.HttpStatus;
import utils.Endpoints;

import static io.restassured.RestAssured.given;

public class TestCaseAdapter extends BaseAdapter {
    public TestCase add(TestCase testCase) {
        String jsonBody = getGson().toJson(testCase);

        return post(
                jsonBody,
                Endpoints.ADD_TESTCASE,
                "section_id",
                ReadProperties.getSelectId(),
                testCase);
    }

    public TestCase update(TestCase testCase) {
        String jsonBody = getGson().toJson(testCase);

        return post(
                jsonBody,
                Endpoints.UPDATE_TESTCASE,
                "case_id",
                testCase.getId(),
                testCase);
    }

    public TestCase post(String jsonBody, String endpoint, String pathParam, int id, TestCase testCase) {
        return given()
                .pathParams(pathParam, id)
                .body(jsonBody)
                .log().all()
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(TestCase.class, ObjectMapperType.GSON);
    }

    public TestCase get(int caseId) {
        return given()
                .pathParam("case_id", caseId)
                .when()
                .get(Endpoints.GET_TESTCASE)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(TestCase.class, ObjectMapperType.GSON);
    }

    public void move(CasesToMove casesToMove) {
        given()
                .pathParam("section_id", ReadProperties.getMoveToSelectId())
                .body(gson.toJson(casesToMove))
                .when()
                .post(Endpoints.MOVE_TESTCASES)
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

    public void delete(TestCase testCase) {
        given()
                .pathParams("case_id", testCase.getId())
                .when()
                .post(Endpoints.DELETE_TESTCASE)
                .then()
                .statusCode(HttpStatus.SC_OK);
    }
}
