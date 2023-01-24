package tests;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class LoggerTest {
    Logger logger = LogManager.getLogger(LoggerTest.class);
    Logger loggerFile = LogManager.getLogger("File");

    @Test
    public void loggerTest(){
        logger.trace("Trace info:");
        logger.debug("Debug info:");
        logger.info("Info info:");
        logger.warn("Warning info:");
        logger.error("Error info:");
        logger.fatal("Fatal info:");

        loggerFile.error("Error info:");
        loggerFile.fatal("Fatal info:");
    }

}
