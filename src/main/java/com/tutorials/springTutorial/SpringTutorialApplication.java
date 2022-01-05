package com.tutorials.springTutorial;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SpringTutorialApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(SpringTutorialApplication.class)
                .profiles("qa")
                .build()
                .run(args);
    }

}
