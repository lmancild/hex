package com.app.delivery.pickup.domain.ports.in.process;

import com.app.delivery.pickup.application.vo.RequestConfirmPickUpVO;

/**
 * @author lmancild
 * @since 1.0.0
 *
 */
public interface IProcessConfirmPickUpService {

	/**
	 * 
	 * @param request
	 */
	void changeStatusToConfirm(RequestConfirmPickUpVO request);
}
