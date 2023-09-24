package com.iexapis.cloud.integration.concurrencystock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@EnableAutoConfiguration(
        exclude = {
                DataSourceAutoConfiguration.class,
        }
)
public class ConcurrencyStockApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConcurrencyStockApplication.class, args);
    }

}
