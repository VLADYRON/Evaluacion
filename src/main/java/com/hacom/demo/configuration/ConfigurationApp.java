package com.hacom.demo.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "prueba")
public class ConfigurationApp {

    private String mongodbDatabase;

    private String mongodbUri;

    private int apiPort;
    
}
