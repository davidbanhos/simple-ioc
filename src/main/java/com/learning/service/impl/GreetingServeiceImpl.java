package com.learning.service.impl;

import com.learning.service.GreetingService;

public class GreetingServeiceImpl implements GreetingService {
    @Override
    public String greet(String name) {
        return "Hello, " + name;
    }

}
