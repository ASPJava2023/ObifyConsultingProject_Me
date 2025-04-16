package com.asp.ObifyConsulting.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
@Bean
    public OpenAPI restApi() {
    return new OpenAPI()
            .info(new Info()
                    .title("Obify Consulting API")
                    .description("API documentation for selected endpoints only")
                    .version("1.0.0"));
    // This creates a group that only includes endpoints under /api/**
}
    @Bean
    public GroupedOpenApi apiGroup() {
            return GroupedOpenApi.builder()
                    .group("API") // Group name shown in Swagger UI
                    .pathsToMatch("/api/**") // Only show docs for endpoints matching this
                    .build();
    }
}
