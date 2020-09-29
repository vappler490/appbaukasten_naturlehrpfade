package com.lipschinski.bauksten;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BaukastenApplication {
    public static void main(String[] args) {
        SpringApplication.run(BaukastenApplication.class, args);
    }
}
