package com.github.pavelburdakov.taskapp.configuration;


import com.github.pavelburdakov.taskapp.configuration.properties.ClientCredentialsProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * REST template для того чтобы ходить в keycloak
 * за токеном, а также в сервис работы с пользователями откуда
 * мы будем получать пользователей
 */
@Configuration
@EnableConfigurationProperties(ClientCredentialsProperties.class)
public class ApplicationConfiguration {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
