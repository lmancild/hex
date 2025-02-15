package com.app.delivery.pickup.infrastructure.mapper;

import com.app.delivery.pickup.application.vo.RequestConfirmPickUpVO;
import com.app.delivery.pickup.application.vo.RequestConfirmPickUpVO.RequestConfirmPickUpStatusVO;
import com.app.delivery.pickup.infrastructure.dto.request.RequestConfirmPickUpDTO;
import com.app.delivery.pickup.infrastructure.dto.request.RequestConfirmPickUpDTO.RequestConfirmPickUpOriginDTO;

/**
 * @author lmancild
 * @since 1.0.0
 *
 */
public class RequestConfirmPickUpMapper {

	/**
	 * 
	 * @param request
	 * @return
	 */
	public static RequestConfirmPickUpVO transformRequestToVO(RequestConfirmPickUpDTO request) {
		RequestConfirmPickUpVO vo = new RequestConfirmPickUpVO();
		vo.setClientId(request.getClientId());
		vo.setEmployeeId(request.getEmployeeId());
		vo.setPurchaseCode(request.getPurchaseCode());
		vo.setStoreId(request.getClientId());
		vo.setOrigin(RequestConfirmPickUpOriginDTO.STORE.equals(request.getOrigin()) ? 
				RequestConfirmPickUpStatusVO.STORE : RequestConfirmPickUpStatusVO.BOX);
		return vo;
	}
}
