package org.example.sinks;

import org.example.dto.Message;
import org.example.enums.LogLevel;

public class ConsoleSink implements Sink {
    private LogLevel level;
    private String timeStampFormat;

    public ConsoleSink() {
    }

    @Override
    public void log(Message message) {
        if (message.getLevel().getPriority() >= level.getPriority()) {
            System.out.println(message.getFormattedMessage(timeStampFormat));
        }
    }

    @Override
    public void setLogLevel(LogLevel level) {
        this.level = level;
    }

    @Override
    public void setTimestampFormat(String timestampFormat) {
        this.timeStampFormat = timestampFormat;
    }
}
