package com.app.delivery.pickup.domain.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.app.delivery.pickup.application.command.CommandConfirmPickUp;
import com.app.delivery.pickup.application.constants.AppDeliveryConstants;
import com.app.delivery.pickup.application.vo.RequestConfirmPickUpVO;
import com.app.delivery.pickup.application.vo.RequestConfirmPickUpVO.RequestConfirmPickUpStatusVO;
import com.app.delivery.pickup.domain.ports.in.process.IProcessConfirmPickUpService;
import com.app.delivery.pickup.domain.ports.out.repository.IPurchaseRepository;

/**
 * @author lmancild
 * @since 1.0.0
 *
 */
@Service
public class ProcessConfirmPickUpServiceImpl implements IProcessConfirmPickUpService {

	
	private IPurchaseRepository purchaseRepository;

	public ProcessConfirmPickUpServiceImpl(IPurchaseRepository purchaseRepository) {
		super();
		this.purchaseRepository = purchaseRepository;
	}

	@Override
	public void changeStatusToConfirm(RequestConfirmPickUpVO request) {
		
		CommandConfirmPickUp command = new CommandConfirmPickUp();
		command.setPurchaseCode(request.getPurchaseCode());
		command.setPickUpDate(new Date());
		if (RequestConfirmPickUpStatusVO.STORE.equals(request.getOrigin())) {
			command.setPruchaseStatus(AppDeliveryConstants.APP_STATUS_DELIVERY_STORE);
		} else {
			command.setPruchaseStatus(AppDeliveryConstants.APP_STATUS_DELIVERY_BOX);
		}
		purchaseRepository.save(command);
	}

}
