package com.app.delivery.pickup.application.ports.out.service;

import com.app.delivery.pickup.infrastructure.dto.request.RequestEmailNotificationDTO;

/**
 * 
 * @author lmancild
 * @since 1.0.0
 */
public interface IEmailDispatcherService {

	/**
	 * 
	 * @param request
	 */
	void dispatchEmailNotification(RequestEmailNotificationDTO request); 
}
