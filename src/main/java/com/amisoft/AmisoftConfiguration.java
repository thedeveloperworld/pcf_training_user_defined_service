package com.amisoft;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AmisoftConfiguration {

    @Bean
    RestTemplate getRestemplate() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate;

    }
}
