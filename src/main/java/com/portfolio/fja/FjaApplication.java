package com.portfolio.fja;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.portfolio.fja"})
public class FjaApplication {

    public static void main(String[] args) {
        SpringApplication.run(FjaApplication.class, args);
    }

}