package com.kevinraupp.nunessports.DesafioEveryMind.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(new Info().title("Nunes Sports").version("v1").description("Desafio EveryMind, Kevin Raupp 2024")
                .termsOfService("").license(new License().name("Apache 2.0").url("")));
    }
}