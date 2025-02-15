package com.app.delivery.pickup.infrastructure.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.Builder;

import com.app.delivery.pickup.application.utils.AppDevileryMessageUtils;
import com.app.delivery.pickup.infrastructure.dto.request.RequestEmailNotificationDTO;

import reactor.core.publisher.Mono;

/**
 * @author lmancild
 * @since 1.0.0
 *
 */
@Component
public class EmailClient {
	
	private static final Logger log = LoggerFactory.getLogger(EmailClient.class);
	
	private String endpoint;
	private Builder webClientBuilder = WebClient.builder();
	
	
	/**
	 * 
	 * @param endpoint
	 */
	public EmailClient(@Value("${external.email.endpoint}") String endpoint) {
		super();
		this.endpoint = endpoint;
	}



	public void senEmailNotification(RequestEmailNotificationDTO request) {
		log.info("--- calling file service api for : {} ---", endpoint);
		log.info(AppDevileryMessageUtils.generatedMessageLog("REQUEST EMAIL NOTIFICATION ",  request));
		Mono<String> response = webClientBuilder
				.build()
				.post()
				.uri(endpoint)
				.bodyValue(request)
				.retrieve()
				.bodyToMono(String.class);
				//.retryWhen(Retry.backoff(retry, Duration.ofSeconds(3)))
				
		response.subscribe(res -> {
			log.info(AppDevileryMessageUtils.generatedMessageLog("EMAIL NOTIFICATION API RESPONSE", res));
		}, error -> {
			log.error("--- error to call email services api ---", error);
		});
	}
	

	
}
