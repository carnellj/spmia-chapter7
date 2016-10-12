package com.thoughtmechanix.licenses.events.handlers;

import com.thoughtmechanix.licenses.events.models.OrganizationChangeModel;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
public class OrganizationChangeHandler {

    @StreamListener(Sink.INPUT)
    public void loggerSink(OrganizationChangeModel orgChange) {
        System.out.println("!!!!!Received from OrgChangeHandler: " + orgChange.toString());
    }
}
