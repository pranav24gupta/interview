package org.example;

import org.example.config.LoggerConfig;
import org.example.enums.LogLevel;
import org.example.logger.Logger;
import org.example.logger.LoggerFactory;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        LoggerConfig config =
                new LoggerConfig("dd-MM-yyyy-HH-mm-ss",LogLevel.ERROR, true, 25, "STDOUT");

        Logger logger = LoggerFactory.createLogger(config);

        logger.log("This is an fatal message.", LogLevel.FATAL);
        logger.log("This is an info message.", LogLevel.INFO);
        logger.log("This is a debug message.", LogLevel.DEBUG); // Should be ignored by console sink
        logger.log("This is an error message.", LogLevel.ERROR);



    }
}