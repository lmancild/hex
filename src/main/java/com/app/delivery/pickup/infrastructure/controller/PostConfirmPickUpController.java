package com.app.delivery.pickup.infrastructure.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.delivery.pickup.application.ports.in.service.IOrchestratorConfirmPickUpService;
import com.app.delivery.pickup.infrastructure.dto.request.RequestConfirmPickUpDTO;
import com.app.delivery.pickup.infrastructure.dto.response.ResponseConfirmPickUpDTO;
import com.app.delivery.pickup.infrastructure.mapper.RequestConfirmPickUpMapper;

import jakarta.validation.Valid;


/**
 * @author lmancild
 * @since 1.0.0
 *
 */
@RestController
public class PostConfirmPickUpController {
	
	
	private static final Logger log = LoggerFactory.getLogger(PostConfirmPickUpController.class);
	private IOrchestratorConfirmPickUpService orchestratorConfirmPickUpService;
	
	
	/**
	 * 
	 * @param orchestratorConfirmPickUpService
	 */
	public PostConfirmPickUpController(IOrchestratorConfirmPickUpService orchestratorConfirmPickUpService) {
		super();
		this.orchestratorConfirmPickUpService = orchestratorConfirmPickUpService;
	}



	@PostMapping(value = "${app.confirm.pickup.endpoint}")
	public ResponseEntity<ResponseConfirmPickUpDTO> requestSearchCancelDetailForApplyEndpoint(
			@Valid @RequestBody RequestConfirmPickUpDTO request) {
		ResponseConfirmPickUpDTO response = orchestratorConfirmPickUpService.process(RequestConfirmPickUpMapper.transformRequestToVO(request));
		log.info("--- response confirm: {} ---", response);
		return ResponseEntity.status(HttpStatus.OK).body(response);

	}

}
