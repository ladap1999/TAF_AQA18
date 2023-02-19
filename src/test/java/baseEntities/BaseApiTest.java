package baseEntities;

import adapters.MilestoneAdapter;
import adapters.ProjectAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import configuration.ReadProperties;
import dbTables.MilestoneTable;
import dbTables.ProjectTable;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import models.Milestone;
import models.Project;
import org.apache.http.protocol.HTTP;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;
import services.DataBaseService;

import java.sql.ResultSet;
import java.sql.SQLException;

import static io.restassured.RestAssured.given;

public class BaseApiTest {
    Logger logger;
    protected DataBaseService dbService;
    protected Gson gson;
    protected MilestoneAdapter milestoneAdapter;
    protected ProjectAdapter projectAdapter;
    protected Milestone expectedMilestone;
    protected Project expectedProject;
    protected ProjectTable projectTable;
    protected MilestoneTable milestoneTable;
    protected int projectID;
    protected Project projectToAdd;
    protected Milestone expectedMilestoneFromDb;

    @BeforeSuite
    public void setupApi() {
        logger = LogManager.getLogger(BaseApiTest.class);
        milestoneAdapter = new MilestoneAdapter();
        gson = getGson();
        dbService = new DataBaseService();
        projectTable = new ProjectTable(dbService);
        projectAdapter = new ProjectAdapter();
        milestoneTable = new MilestoneTable(dbService);
        RestAssured.baseURI = ReadProperties.getUrl();

        RestAssured.requestSpecification = given()
                .auth().preemptive().basic(ReadProperties.username(), ReadProperties.password())
                .header(HTTP.CONTENT_TYPE, ContentType.JSON);
    }

    @BeforeSuite(dependsOnMethods = "setupApi")
    public void createAndFilTables() {
        logger.info("CreateAndFillTables");
        expectedProject = Project.builder()
                .name("Project_by_Petkevich")
                .announcement("Step_by_step")
                .showAnnouncement(true)
                .build();

        expectedMilestone = Milestone.builder()
                .name("New_Milestone_For_RestAPI")
                .description("For_RestAPI")
                .isStarted(false)
                .isCompleted(false)
                .startedOn(1676854411)
                .startDate(1676854410)
                .build();

        projectTable.createProjectTable();
        milestoneTable.createMilestoneTable();
        projectTable.addProject(expectedProject);
        milestoneTable.addMilestone(expectedMilestone);
    }

    @BeforeSuite(dependsOnMethods = "createAndFilTables")
    public void addProjectApi() {
        logger.info("Create Project API request");
        ResultSet resultProjectsSet = projectTable.getProjects();
        try {
            while (resultProjectsSet.next()) {
                projectToAdd = Project.builder()
                        .name(resultProjectsSet.getString("name"))
                        .announcement(resultProjectsSet.getString("announcement"))
                        .showAnnouncement(resultProjectsSet.getBoolean("showAnnouncement"))
                        .build();
                projectID = projectAdapter.addProject(projectToAdd);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @BeforeSuite(dependsOnMethods = "addProjectApi")
    public void addMilestoneApi() {
        logger.info("Create Milestone API request");
        ResultSet resultMilestonesSet = milestoneTable.getMilestones();
        try {
            while (resultMilestonesSet.next()) {
                expectedMilestoneFromDb = Milestone.builder()
                        .name(resultMilestonesSet.getString("name"))
                        .description(resultMilestonesSet.getString("description"))
                        .isStarted(resultMilestonesSet.getBoolean("isStarted"))
                        .isCompleted(resultMilestonesSet.getBoolean("isCompleted"))
                        .build();
                milestoneAdapter.add(expectedMilestone, projectID);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Gson getGson() {
        if (gson == null) {
            gson = new Gson();
            gson = new GsonBuilder()
                    .excludeFieldsWithoutExposeAnnotation()
                    .create();
        }
        return gson;
    }

    @AfterTest
    public void tearDown() {
        dbService.closeConnection();
    }

    @AfterClass
    public void clearTestData() {
        logger.info("Clear tables");
        projectTable.dropTable();
        milestoneTable.dropTable();
        projectAdapter.deleteProject(projectID);
    }
}