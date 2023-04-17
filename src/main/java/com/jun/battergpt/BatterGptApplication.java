package com.jun.battergpt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class BatterGptApplication {

    public static void main(String[] args) {
        SpringApplication.run(BatterGptApplication.class, args);
    }

}
