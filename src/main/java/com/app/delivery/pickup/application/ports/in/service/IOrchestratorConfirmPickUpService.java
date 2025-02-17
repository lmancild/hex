package com.app.delivery.pickup.application.ports.in.service;

import com.app.delivery.pickup.application.vo.RequestConfirmPickUpVO;
import com.app.delivery.pickup.infrastructure.dto.response.ResponseConfirmPickUpDTO;

/**
 * @author lmancild
 * @since 1.0.0
 *
 */
public interface IOrchestratorConfirmPickUpService {

	/**
	 * 
	 * @param request
	 * @return
	 */
	ResponseConfirmPickUpDTO process(RequestConfirmPickUpVO request);
	
}
