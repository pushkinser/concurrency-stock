package com.iexapis.cloud.integration.concurrencystock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ConcurrencyStockApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConcurrencyStockApplication.class, args);
    }

}
