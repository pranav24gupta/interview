package org.example.logger;

import org.example.config.LoggerConfig;
import org.example.dto.Message;
import org.example.enums.LogLevel;
import org.example.sinks.Sink;
import org.example.sinks.SinkFactory;

import java.util.ArrayList;
import java.util.List;

public class SyncLogger implements Logger {
    private final List<Sink> sinks = new ArrayList<>();

    public SyncLogger(LoggerConfig config) {
        Sink sink = SinkFactory.createSink(config.getSinkType());
        sink.setLogLevel(config.getLogLevel());
        sink.setTimestampFormat(config.getTimestampFormat());
        sinks.add(sink);
    }

    @Override
    public void log(String content, LogLevel level) {
        Message message = new Message(content, level);
        sendToSinks(message);
    }

    private void sendToSinks(Message message) {
        for (Sink sink : sinks) {
            try {
                sink.log(message);
            } catch (Exception e) {
                System.err.println("Failed to log message to sink: " + e.getMessage());
            }
        }
    }
}
