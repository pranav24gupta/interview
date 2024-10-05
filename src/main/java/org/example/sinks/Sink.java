package org.example.sinks;

import org.example.dto.Message;
import org.example.enums.LogLevel;

public interface Sink {
    void log(Message message);

    void setLogLevel(LogLevel level);

    void setTimestampFormat(String timestampFormat);
}
