package org.example.logger;

import org.example.enums.LogLevel;

public interface Logger {
    void log(String content, LogLevel level);
}
