package io.playwright.example.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggingUtil {
    protected static Logger loggingUtil = LogManager.getLogger();

    public void logInfo(String message) {
        loggingUtil.info(message);
    }
}
