package dbTables;

import models.Project;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import services.DataBaseService;

import java.sql.ResultSet;

public class ProjectTable {
    Logger logger = LogManager.getLogger(ProjectTable.class);

    private DataBaseService dbService;

    public ProjectTable(DataBaseService dbService) {
        this.dbService = dbService;
    }

    public void createProjectTable() {
        logger.info("Create projects tables");

        String createProjectTableSQL = "" +
                "create table public.projects " +
                "(id SERIAL PRIMARY KEY," +
                "    name CHARACTER VARYING(30)," +
                "    announcement CHARACTER VARYING(30)," +
                "    showAnnouncement BOOLEAN" +
                ");";

        dbService.executeSQL(createProjectTableSQL);
    }

    public void dropTable() {
        logger.info("Удаляем projects таблицу");

        String dropTableSQL = "DROP table if exists public.projects;";

        dbService.executeSQL(dropTableSQL);
    }

    public ResultSet getProjects() {
        String sql = "SELECT * FROM public.projects;";

        return dbService.executeQuery(sql);
    }

    public void addProject(Project project) {
        String insertProjectTableSQL = "INSERT INTO public.projects(" +
                "name, announcement, showAnnouncement)" +
                "VALUES ('" + project.getName() + "', '" + project.getAnnouncement() +
                "', '" + project.isShowAnnouncement() + "');";

        dbService.executeSQL(insertProjectTableSQL);
    }
}
