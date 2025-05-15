package com.example.evaluation.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*") // Autorise tous les domaines
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Méthodes autorisées
                .allowCredentials(true); // Autorise l'envoi des cookies / headers
    }
}
