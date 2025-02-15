package com.app.delivery.pickup.infrastructure.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.delivery.pickup.application.utils.AppDevileryMessageUtils;
import com.app.delivery.pickup.infrastructure.dto.request.RequestConfirmPickUpDTO;
import com.app.delivery.pickup.infrastructure.dto.response.ResponseBaseDTO;
import com.app.delivery.pickup.infrastructure.service.RequestPickUpDispatcherService;

import jakarta.validation.Valid;
import reactor.core.publisher.Mono;


/**
 * @author lmancild
 * @since 1.0.0
 *
 */
@RestController
public class PostConfirmPickUpController {
	
	
	private static final Logger log = LoggerFactory.getLogger(PostConfirmPickUpController.class);
	private RequestPickUpDispatcherService dispatcherService;
	
	
	/**
	 * 
	 * @param dispatcherService
	 */
	public PostConfirmPickUpController(RequestPickUpDispatcherService dispatcherService) {
		super();
		this.dispatcherService = dispatcherService;
	}



	@PostMapping(value = "${app.confirm.pickup.endpoint}")
	public Mono<ResponseEntity<ResponseBaseDTO>> requestSearchCancelDetailForApplyEndpoint(
			@Valid @RequestBody RequestConfirmPickUpDTO request) {
		Mono<ResponseBaseDTO> response = dispatcherService.delegateMessage(request);
		return response.map(res -> {
			log.info(AppDevileryMessageUtils.generatedMessageLog("REQUEST CONFIRM PICK UP RESPONSE", res));
			return ResponseEntity.status(HttpStatus.OK).body(res);
		});

	}

}
