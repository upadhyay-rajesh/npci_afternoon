package com.mybanking.config;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
//@Profile("dev")
public class OpenAPIConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Employee Management API")
                        .version("1.0.0")
                        .description("API for managing employees in the UPCI Family")
                        .contact(new Contact()
                                .name("Rajesh Upadhyay")
                                .email("upadhyay.rajesh@rediffmail.com")
                                .url("https://rkcptraining.com")));
    }
}
