package tests.api;

import baseEntities.BaseApiGsonTest;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import models.User;
import org.apache.http.HttpStatus;
import org.openqa.selenium.json.TypeToken;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestRailApiTest2 extends BaseApiGsonTest {

    @Test
    public void getUser() {
        int userID = 1;

        String endpoint = "index.php?/api/v2/get_user/{user_id}";

        User expectedUserGui = User.builder()
                .name("Aleksandr Trostyanko")
                .email("atrostyanko@gmail.com")
                .isActive(true)
                .isAdmin(true)
                .roleId(1)
                .role("Lead")
                .build();

        User actualUserGui = given()
                .pathParam("user_id", userID)
                .get(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(User.class, ObjectMapperType.GSON);

        System.out.println(actualUserGui.toString());

        Assert.assertEquals(actualUserGui, expectedUserGui);
    }

    @Test
    public void getUser1() {
        int userID = 1;

        String endpoint = "index.php?/api/v2/get_user/{user_id}";

        User expectedUserGui = User.builder()
                .name("Aleksandr Trostyanko")
                .email("atrostyanko@gmail.com")
                .isActive(true)
                .isAdmin(true)
                .roleId(1)
                .role("Lead")
                .build();

        Response response = given()
                .pathParam("user_id", userID)
                .get(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();

        User actualUserGui = gson.fromJson(response.getBody().asPrettyString(), User.class);
        System.out.println(actualUserGui.toString());

        Assert.assertEquals(actualUserGui, expectedUserGui);
    }

    @Test
    public void getUser2() {
        int userID = 1;

        String endpoint = "index.php?/api/v2/get_user/{user_id}";

        User expectedUserGui = User.builder()
                .name("Aleksandr Trostyanko")
                .email("atrostyanko@gmail.com")
                .isActive(true)
                .isAdmin(true)
                .roleId(1)
                .role("Lead")
                .build();

        User actualUserGui = given()
                .pathParam("user_id", userID)
                .get(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(User.class);

        System.out.println(actualUserGui.toString());
        System.out.println(expectedUserGui.toString());

        Assert.assertEquals(actualUserGui, expectedUserGui);
    }

    @Test
    public void getAllUsers1() {
        String endpoint = "index.php?/api/v2/get_users";

        Response response = given()
                .when()
                .get(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();

        User[] actualUserListGui = gson.fromJson(response.getBody().asPrettyString(),
                User[].class);

        System.out.println(actualUserListGui.length);
        System.out.println(actualUserListGui[0].toString());
        System.out.println(actualUserListGui[1].toString());
    }

    @Test
    public void getAllUsers2() {
        String endpoint = "index.php?/api/v2/get_users";

        Response response = given()
                .when()
                .get(endpoint)
                .then()
                .assertThat()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();

        Type listType = new TypeToken<ArrayList<User>>(){}.getType();

        List<User> actualUserListGui = gson.fromJson(response.getBody().asPrettyString(),
                listType);

        System.out.println(actualUserListGui.size());
        System.out.println(actualUserListGui.get(0).toString());
        System.out.println(actualUserListGui.get(1).toString());
    }
}
