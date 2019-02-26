package com.agap.aggregatorrest.config;

import com.google.cloud.dialogflow.v2.SessionsClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class MainConfig {

    public MainConfig() {}

    @Bean
    public SessionsClient sessionsClient() throws IOException {
        return SessionsClient.create();
    }

}
