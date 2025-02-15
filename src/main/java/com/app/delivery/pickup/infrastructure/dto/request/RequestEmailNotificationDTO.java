package com.app.delivery.pickup.infrastructure.dto.request;

import com.app.delivery.pickup.application.utils.AppDeliveryUtils;

/**
 * @author lmancild
 * @since 1.0.0
 *
 */
public class RequestEmailNotificationDTO {

	
	
	private String purchaseCode;
	private String clientId;

	public RequestEmailNotificationDTO(String purchaseCode, String clientId) {
		super();
		this.purchaseCode = purchaseCode;
		this.clientId = clientId;
	}

	public String getPurchaseCode() {
		return purchaseCode;
	}
	
	public String getClientId() {
		return clientId;
	}
	
	@Override
	public String toString() {
		return AppDeliveryUtils.printIdentJSON(this);
	}
	
}
