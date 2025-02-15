package com.app.delivery.pickup.application.vo;

import com.app.delivery.pickup.application.utils.AppDeliveryUtils;

/**
 * @author lmancild
 * @since 1.0.0
 *
 */
public class RequestConfirmPickUpVO {

	private String storeId;
	private String employeeId;
	private String purchaseCode;
	private String clientId;
	private RequestConfirmPickUpStatusVO origin;

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getPurchaseCode() {
		return purchaseCode;
	}

	public void setPurchaseCode(String purchaseCode) {
		this.purchaseCode = purchaseCode;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public RequestConfirmPickUpStatusVO getOrigin() {
		return origin;
	}

	public void setOrigin(RequestConfirmPickUpStatusVO origin) {
		this.origin = origin;
	}



	public static enum RequestConfirmPickUpStatusVO {
		
		STORE,BOX;
	}

	@Override
	public String toString() {
		return AppDeliveryUtils.printIdentJSON(this);
	}
}
