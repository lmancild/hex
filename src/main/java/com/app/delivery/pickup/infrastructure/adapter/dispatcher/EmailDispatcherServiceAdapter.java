package com.app.delivery.pickup.infrastructure.adapter.dispatcher;

import org.springframework.stereotype.Service;

import com.app.delivery.pickup.application.ports.out.service.IEmailDispatcherService;
import com.app.delivery.pickup.infrastructure.client.EmailClient;
import com.app.delivery.pickup.infrastructure.dto.request.RequestEmailNotificationDTO;

/**
 * @author lmancild
 * @since 1.0.0
 *
 */
@Service
public class EmailDispatcherServiceAdapter implements IEmailDispatcherService {

	private EmailClient emailClient;
	
	
	
	public EmailDispatcherServiceAdapter(EmailClient emailClient) {
		super();
		this.emailClient = emailClient;
	}



	@Override
	public void dispatchEmailNotification(RequestEmailNotificationDTO request) {
		this.emailClient.senEmailNotification(request);
	}

}
