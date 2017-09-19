package com.sujit.controller;

import com.sujit.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @Autowired
    private HelloService helloService;


    @GetMapping("/api/v2/hello")
    public ResponseEntity<String> getHello(){

        return new ResponseEntity<String>(helloService.getHello(), HttpStatus.OK);

    }



}
