package org.example.config;

import org.example.enums.LogLevel;

public class LoggerConfig {
    private String timestampFormat;
    private LogLevel logLevel;
    private boolean asyncLogging;
    private int bufferSize;
    private String sinkType;

    public LoggerConfig(String timestampFormat, LogLevel logLevel, boolean asyncLogging, int bufferSize, String sinkType) {
        this.timestampFormat = timestampFormat;
        this.logLevel = logLevel;
        this.asyncLogging = asyncLogging;
        this.bufferSize = bufferSize;
        this.sinkType = sinkType;
    }

    public String getTimestampFormat() {
        return timestampFormat;
    }

    public LogLevel getLogLevel() {
        return logLevel;
    }

    public boolean isAsyncLogging() {
        return asyncLogging;
    }

    public int getBufferSize() {
        return bufferSize;
    }

    public String getSinkType() {
        return sinkType;
    }
}
