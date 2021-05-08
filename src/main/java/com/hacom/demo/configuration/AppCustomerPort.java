package com.hacom.demo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;

@Component
public class AppCustomerPort implements WebServerFactoryCustomizer<ConfigurableWebServerFactory> {
    
    @Autowired
    ConfigurationApp configuration;

    @Override
    public void customize(ConfigurableWebServerFactory factory) {
        factory.setPort(configuration.getApiPort());
    }

}
