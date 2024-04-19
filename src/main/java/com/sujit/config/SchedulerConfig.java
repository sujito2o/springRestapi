package com.sujit.config;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Random;

@EnableScheduling
@Configuration
public class SchedulerConfig {
    private static final Logger logger =
            LoggerFactory.getLogger(SchedulerConfig.class);


    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Scheduled(fixedDelay = 500)
    public void sendAdhocMessages() {
        Random random = new Random();
        int randomInteger = random.nextInt(50);
       logger.debug("random integer pushed : "+randomInteger);
        kafkaTemplate.send("livetemperature",String.valueOf(randomInteger));

//        template.convertAndSend("/topic/temperature", randomInteger);
    }
}