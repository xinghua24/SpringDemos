package com.xinghua24.springdocopenapi;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiConfig {
    @Bean
    public GroupedOpenApi gettingApi() {
        return GroupedOpenApi.builder()
                .group("Greeting")
                .pathsToMatch("/greeting/**")
                .packagesToScan("com.xinghua24.springdocopenapi.controller")

                .build();
    }

    @Bean
    public GroupedOpenApi ItemApi() {
        return GroupedOpenApi.builder()
                .group("Item")
                .pathsToMatch("/items/**")
                .packagesToScan("com.xinghua24.springdocopenapi.controller")

                .build();
    }

    @Bean
    public OpenAPI MyOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("My API")
                        .description("My sample application")
                        .version("v0.0.1")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                ;
    }
}
