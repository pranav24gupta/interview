package org.example.sinks;

import org.example.enums.LogLevel;

public class SinkFactory {
    public static Sink createSink(String sinkType) {
        switch (sinkType.toUpperCase()) {
            case "STDOUT":
                return new ConsoleSink();
            // Additional sink types can be added here
            default:
                throw new IllegalArgumentException("Unknown sink type: " + sinkType);
        }
    }
}
