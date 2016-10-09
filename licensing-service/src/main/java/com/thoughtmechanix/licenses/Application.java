package com.thoughtmechanix.licenses;

import com.thoughtmechanix.licenses.utils.UserContextInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.client.RestTemplate;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
//@EnableBinding(Sink.class)
@EnableBinding(Source.class)
public class Application {

    @LoadBalanced
    @Bean
    public RestTemplate getRestTemplate(){
        RestTemplate template = new RestTemplate();
        List interceptors = template.getInterceptors();
        if (interceptors==null){
            template.setInterceptors(Collections.singletonList(new UserContextInterceptor()));
        }
        else{
            interceptors.add(new UserContextInterceptor());
            template.setInterceptors(interceptors);
        }

        return template;
    }

    @Bean
    @InboundChannelAdapter(value = Source.OUTPUT, poller = @Poller(fixedDelay = "10000", maxMessagesPerPoll = "1"))
    public MessageSource<TimeInfo> timerMessageSource() {
        System.out.println("!!!!!!Sending Kafka message");
        return () -> MessageBuilder.withPayload(new TimeInfo(new Date().getTime() + "", "Label")).build();
    }



    public static class TimeInfo{

        private String time;
        private String label;

        public TimeInfo(String time, String label) {
            super();
            this.time = time;
            this.label = label;
        }

        public String getTime() {
            return time;
        }

        public String getLabel() {
            return label;
        }

    }

    public static class SinkTimeInfo{

        private String time;
        private String label;

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public void setSinkLabel(String label) {
            this.label = label;
        }

        public String getLabel() {
            return label;
        }

        @Override
        public String toString() {
            return "SinkTimeInfo [time=" + time + ", label=" + label + "]";
        }

    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
