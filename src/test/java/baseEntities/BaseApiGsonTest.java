package baseEntities;

import adapters.MilestoneAdapter;
import adapters.TestCaseAdapter;
import com.google.gson.GsonBuilder;
import configuration.ReadProperties;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import models.Milestone;
import models.TestCase;
import org.apache.http.protocol.HTTP;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import com.google.gson.Gson;

import static io.restassured.RestAssured.given;

public class BaseApiGsonTest {
    protected Gson gson;
    protected MilestoneAdapter milestoneAdapter;
    protected TestCaseAdapter testCaseAdapter;
    protected Milestone expectedMilestone;
    protected TestCase expectedTestCase;

    @BeforeSuite
    public void setExpectedTestDataForMilestone() {
        expectedMilestone = Milestone.builder()
                .name("New_Milestone_For_RestAPI")
                .description("For_RestAPI")
                .id(8)
                .startDate(1641998289)
                .dueDate(1673534299)
                .isStarted(false)
                .isCompleted(false)
                .build();
    }

    @BeforeSuite
    public void setExpectedTestDataForTestCase() {
        expectedTestCase = TestCase.builder()
                .title("FirstApiTestCase")
                .priorityId(2)
                .templateId(1)
                .typeId(2)
                .sectionId(3)
                .build();
    }

    @BeforeTest
    public void setupApi() {
        milestoneAdapter = new MilestoneAdapter();
        testCaseAdapter = new TestCaseAdapter();
        gson = new Gson();
        gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();

        RestAssured.baseURI = ReadProperties.getUrl();
        RestAssured.requestSpecification = given()
                .auth().preemptive().basic(ReadProperties.username(), ReadProperties.password())
                .header(HTTP.CONTENT_TYPE, ContentType.JSON);
    }
}
