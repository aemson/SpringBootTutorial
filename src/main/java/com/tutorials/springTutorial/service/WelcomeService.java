package com.tutorials.springTutorial.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public record WelcomeService(String welcomeMessage) {

    public WelcomeService(@Value("${welcome.message}") String welcomeMessage) {
        this.welcomeMessage = welcomeMessage;
    }

}
