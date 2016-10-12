package com.thoughtmechanix.organization.events.source;

import com.thoughtmechanix.organization.event.models.OrganizationChangeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class SimpleSourceBean {
    private Source source;

    @Autowired
    public SimpleSourceBean(Source source){
        this.source = source;
    }

    public void publishOrgChange(String orgId){
        System.out.println("!!!!!!Sending Kafka message for Organization Id");
        OrganizationChangeModel change =  new OrganizationChangeModel(
                OrganizationChangeModel.class.getTypeName(),
                "GET",
                orgId,
                new Date().getTime() + "");

        source.output().send(MessageBuilder.withPayload(change).build());
    }
}
