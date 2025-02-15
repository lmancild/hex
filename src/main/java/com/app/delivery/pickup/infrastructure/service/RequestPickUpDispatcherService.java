package com.app.delivery.pickup.infrastructure.service;

import org.springframework.stereotype.Service;

import com.app.delivery.pickup.application.ports.in.service.IOrchestratorConfirmPickUpService;
import com.app.delivery.pickup.infrastructure.dto.request.RequestConfirmPickUpDTO;
import com.app.delivery.pickup.infrastructure.dto.response.ResponseBaseDTO;
import com.app.delivery.pickup.infrastructure.mapper.RequestConfirmPickUpMapper;

import reactor.core.publisher.Mono;

/**
 * @author lmancild
 * @since 1.0.0
 *
 */
@Service
public class RequestPickUpDispatcherService {

	private IOrchestratorConfirmPickUpService orchestratorConfirmPickUpService;

	/**
	 * 
	 * @param orchestratorConfirmPickUpService
	 */
	public RequestPickUpDispatcherService(IOrchestratorConfirmPickUpService orchestratorConfirmPickUpService) {
		super();
		this.orchestratorConfirmPickUpService = orchestratorConfirmPickUpService;
	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	public Mono<ResponseBaseDTO> delegateMessage(RequestConfirmPickUpDTO request) {
		return Mono.fromCallable(() -> {
			return orchestratorConfirmPickUpService.process(RequestConfirmPickUpMapper.transformRequestToVO(request));
		});
	}
	
	
}
