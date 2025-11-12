package com.example.stepflow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class StepflowApplication {

    public static void main(String[] args) {
        SpringApplication.run(StepflowApplication.class, args);
    }

}
