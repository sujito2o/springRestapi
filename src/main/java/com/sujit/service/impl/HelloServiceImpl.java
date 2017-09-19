package com.sujit.service.impl;

import com.sujit.service.HelloService;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {




    @Override
    public String getHello() {
        return "sujit yadav";
    }
}
