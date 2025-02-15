package com.app.delivery.pickup.infrastructure.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author lmancild
 * @since 1.0.0
 *
 */
@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.app.delivery.pickup.infrastructure.persistence.repository")
@EntityScan(basePackages = "com.app.delivery.pickup.infrastructure.persistence.entity")
@ComponentScan("com.app.delivery.pickup")
public class AppDeliveryApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(AppDeliveryApplication.class, args);
	}
	
}
