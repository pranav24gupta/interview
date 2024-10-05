package org.example.logger;

import org.example.config.LoggerConfig;
import org.example.dto.Message;
import org.example.enums.LogLevel;
import org.example.sinks.Sink;
import org.example.sinks.SinkFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class AsyncLogger implements Logger {
    private final List<Sink> sinks = new ArrayList<>();
    private final BlockingQueue<Message> messageQueue;

    public AsyncLogger(LoggerConfig config) {
        this.messageQueue = new LinkedBlockingQueue<>(config.getBufferSize());
        Sink sink = SinkFactory.createSink(config.getSinkType());
        sink.setLogLevel(config.getLogLevel());
        sink.setTimestampFormat(config.getTimestampFormat());
        sinks.add(sink);
        new Thread(this::processMessages).start();
    }

    @Override
    public void log(String content, LogLevel level) {
        Message message = new Message(content, level);
        try {
            messageQueue.put(message);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Logging interrupted: " + e.getMessage());
        }
    }

    private void processMessages() {
        while (true) {
            try {
                Message message = messageQueue.take();
                sendToSinks(message);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
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
