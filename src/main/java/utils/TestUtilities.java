package utils;

import org.apache.log4j.Logger;

public class TestUtilities {

    private static final Logger logger = Logger.getLogger(TestUtilities.class);

    public static void assertEqual(Object actual, Object expected, String message) {
        if (actual.equals(expected)) {
            logger.info(message + " Passed");
        } else {
            logger.error(message + " Failed: Expected " + expected + " but found " + actual);
        }
    }

    public static void logInfo(String message) {
        logger.info(message);
    }

    public static void logError(String message) {
        logger.error(message);
    }

    public static String formatData(String data) {
        // Implement data formatting logic
        return data;
    }

    // Add more helper methods as needed
}
