package com.app.delivery.pickup.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;


/**
 * @author lmancild
 * @since 1.0.0
 *
 */
@Configuration
public class ApiDocConfiguration {

	@Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API PICK UP")
                        .version("1.0")
                        .description(""));
    }
}
