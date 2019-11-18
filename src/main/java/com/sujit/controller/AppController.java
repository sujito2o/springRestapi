package com.sujit.controller;

import com.sujit.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Random;

@Controller
public class AppController {
    private static final Logger logger =
            LoggerFactory.getLogger(AppController.class);
    @Autowired
    private HelloService helloService;

    @Autowired
    SimpMessagingTemplate template;

    @GetMapping("/api/v2/hello")
    public ResponseEntity<String> getHello(){



        Random random = new Random();
        int randomInteger = random.nextInt(50);
        logger.debug("random integer pushed : "+randomInteger);
        template.convertAndSend("/topic/temperature", randomInteger);
        return new ResponseEntity<String>(helloService.getHello(), HttpStatus.OK);

    }



}
