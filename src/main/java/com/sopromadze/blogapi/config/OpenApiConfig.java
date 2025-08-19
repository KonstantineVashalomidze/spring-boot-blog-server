package com.sopromadze.blogapi.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("Spring Boot Blog Server API")
                                .version("1.0")
                                .description("Blogging application server API")
                                .contact(
                                        new Contact()
                                                .name("Konstantine Vashalomidze")
                                                .email("vashalomidzekonstantine@gmail.com")
                                )
                );
    }

}
