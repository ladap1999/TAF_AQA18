package dbTables;

import models.Milestone;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import services.DataBaseService;

import java.sql.ResultSet;

public class MilestoneTable {
    Logger logger = LogManager.getLogger(MilestoneTable.class);

    private DataBaseService dbService;

    public MilestoneTable(DataBaseService dbService) {
        this.dbService = dbService;
    }

    public void createMilestoneTable() {
        logger.info("Create milestones table");

        String createMilestoneTableSQL = "" +
                "create table public.milestones " +
                "(id SERIAL PRIMARY KEY," +
                "    name CHARACTER VARYING(30)," +
                "    description CHARACTER VARYING(30)," +
                "    isStarted BOOLEAN," +
                "    isCompleted BOOLEAN" +
                ");";

        dbService.executeSQL(createMilestoneTableSQL);
    }

    public void dropTable() {
        logger.info("Удаляем milestones таблицу");

        String dropTableSQL = "DROP table if exists public.milestones;";

        dbService.executeSQL(dropTableSQL);
    }

    public ResultSet getMilestones() {
        String sql = "SELECT * FROM public.milestones;";

        return dbService.executeQuery(sql);
    }

    public ResultSet getMilestoneByName(String name) {
        String sql = "SELECT * FROM public.milestones WHERE name = '" + name + "';";

        return dbService.executeQuery(sql);
    }

    public void addMilestone(Milestone milestone) {
        String insertMilestoneTableSQL = "INSERT INTO public.milestones(" +
                "name, description, isStarted, isCompleted)" +
                "VALUES ('" + milestone.getName() + "', '" + milestone.getDescription() +
                "', '" + milestone.isStarted() + "','" + milestone.isCompleted() + "');";

        dbService.executeSQL(insertMilestoneTableSQL);
    }

    public void updateMilestoneName(Milestone milestone, String updatedString) {
        String updateMilestoneTableSQL = "UPDATE public.milestones SET name = '"
                + updatedString + "' WHERE name = '" + milestone.getName() + "'";
        dbService.executeSQL(updateMilestoneTableSQL);
    }

    public void deleteMilestone(String description) {
        String deleteTableSQL = "DELETE FROM public.milestones WHERE description = '" + description + "';";
        dbService.executeSQL(deleteTableSQL);
    }
}
