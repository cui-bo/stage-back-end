package com.example.demo.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")                      // Endpoint
                .allowedOrigins("*")                              // Origins
                .allowedMethods("GET", "POST", "PUT", "DELETE")   // HTTP methods
                .allowedHeaders("*");                             // Headers
    }

}
