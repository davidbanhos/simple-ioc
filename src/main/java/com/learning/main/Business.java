package com.learning.main;

import com.learning.service.GreetingService;

import javax.inject.Inject;

public class Business {

    private GreetingService greetingService;

    @Inject
    public Business(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String run(String someone) {
        return greetingService.greet(someone);
    }

}
