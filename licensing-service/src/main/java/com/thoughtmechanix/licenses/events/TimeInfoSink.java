package com.thoughtmechanix.licenses.events;

import com.thoughtmechanix.licenses.Application;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Bean;

@EnableBinding(Sink.class)
public class TimeInfoSink {

    @StreamListener(Sink.INPUT)
    public void loggerSink(Application.SinkTimeInfo sinkTimeInfo) {
        System.out.println("!!!!!Received: " + sinkTimeInfo.toString());
    }
}
