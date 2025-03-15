package framework.utils;


import org.testng.Reporter;

public class TestLogger extends ExtentInit {

    public static void log(String log) {
        Reporter.log(log);
    }

    public static void debugLog(String message) {
        log("[DEBUG] - " + message);
    }

    public static void testInfoLog(String message) {
        if (logger != null) {
            logger.info(message);
        } else {
            log("[INFO] - " + message );
        }
    }

    public static void testStepsLog(String message) {
        if (logger != null) {
            logger.info(message);
        } else {
            log("[STEP] - " + message);
        }
    }
}
