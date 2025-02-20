package com.arthurlamberti.ecommerce.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile({"local"})
public class OpenApiConfiguration {

    @Bean
    public GroupedOpenApi api() {
        return GroupedOpenApi.builder()
                .group("ecommerce")
                .packagesToScan("com.arthurlamberti.ecommerce.controller")
                .build();
    }

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Ecommerce API")
                        .description("Ecommerce API Documentation")
                        .version("1.0")
                        .contact(new Contact()
                                .name("Arthur Lamberti")
                                .email("arthur.lamberti.dev@gmail.com")
                        )
                );
    }

}
