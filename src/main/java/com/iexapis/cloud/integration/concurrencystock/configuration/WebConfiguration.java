package com.iexapis.cloud.integration.concurrencystock.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * WebConfiguration
 *
 * @author Aleksey_Krivotulov
 * <p>
 * 22.09.2023
 */
@Configuration
public class WebConfiguration {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
