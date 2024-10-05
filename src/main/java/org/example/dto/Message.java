package org.example.dto;

import org.example.enums.LogLevel;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Message {

    private final String content;
    private final LogLevel level;

    public Message(String content, LogLevel level) {
        this.content = content;
        this.level = level;
    }

    public String getFormattedMessage(String timestampFormat) {
        String timestamp = new SimpleDateFormat(timestampFormat).format(new Date());
        return String.format("%s [%s] %s", timestamp, level, content);
    }

    public LogLevel getLevel() {
        return level;
    }
}
