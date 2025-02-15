package com.app.delivery.pickup.application.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.app.delivery.pickup.application.ports.in.service.IOrchestratorConfirmPickUpService;
import com.app.delivery.pickup.application.ports.out.service.IEmailDispatcherService;
import com.app.delivery.pickup.application.utils.AppDevileryMessageUtils;
import com.app.delivery.pickup.application.vo.RequestConfirmPickUpVO;
import com.app.delivery.pickup.domain.ports.in.process.IProcessConfirmPickUpService;
import com.app.delivery.pickup.domain.service.ProcessConfirmPickUpServiceImpl;
import com.app.delivery.pickup.infrastructure.dto.request.RequestEmailNotificationDTO;
import com.app.delivery.pickup.infrastructure.dto.response.ResponseBaseDTO;

/**
 * @author lmancild
 * @since 1.0.0
 *
 */
@Service
public class OrchestratorPickUpServiceImpl implements IOrchestratorConfirmPickUpService {

	private static final Logger log = LoggerFactory.getLogger(ProcessConfirmPickUpServiceImpl.class);
	private IEmailDispatcherService emailDispatcherService;
	private IProcessConfirmPickUpService processService;
	
	
	/**
	 * 
	 * @param emailDispatcherService
	 * @param processService
	 */
	public OrchestratorPickUpServiceImpl(IEmailDispatcherService emailDispatcherService,
			IProcessConfirmPickUpService processService) {
		super();
		this.emailDispatcherService = emailDispatcherService;
		this.processService = processService;
	}



	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
	public ResponseBaseDTO process(RequestConfirmPickUpVO request) {
	
		log.info("--- start process confirm pick up for: {}, client id: {} ---", request.getPurchaseCode(), request.getClientId());
		ResponseBaseDTO response = new ResponseBaseDTO.Builder("OK").build();
		processService.changeStatusToConfirm(request);
		emailDispatcherService.dispatchEmailNotification(new RequestEmailNotificationDTO(request.getPurchaseCode(),
				request.getClientId()));
		log.info(AppDevileryMessageUtils.generatedMessageLog("RESULT PROCESS CONFIRM PICK UP",  request));
		return response;
	}

}
