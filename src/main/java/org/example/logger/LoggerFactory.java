package org.example.logger;

import org.example.config.LoggerConfig;

public class LoggerFactory {
    public static Logger createLogger(LoggerConfig config) {
        if (config.isAsyncLogging()) {
            return new AsyncLogger(config);
        } else {
            return new SyncLogger(config);
        }
    }
}
