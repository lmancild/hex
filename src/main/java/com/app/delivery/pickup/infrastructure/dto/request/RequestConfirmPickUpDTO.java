package com.app.delivery.pickup.infrastructure.dto.request;

import com.app.delivery.pickup.application.utils.AppDeliveryUtils;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * @author lmancild
 * @since 1.0.0
 *
 */
public class RequestConfirmPickUpDTO {

	@NotNull(message = "store id cannot be null")
	@Size(max = 10, message = "store id max lenght 10")
	private String storeId;
	
	@NotNull(message = "employee id cannot be null")
	@Size(max = 50, message = "employee id max lenght 10")
	private String employeeId;
	
	@NotNull(message = "purchase code cannot be null")
	@Size(max = 50, message = "pruchase code max lenght 50")
	private String purchaseCode;
	
	@NotNull(message = "client id cannot be null")
	@Size(max = 10, message = "client id max lenght 10")
	private String clientId;
	
	@NotNull(message = "origin cannot be null")
	private RequestConfirmPickUpOriginDTO origin;
	
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
	public RequestConfirmPickUpOriginDTO getOrigin() {
		return origin;
	}
	public void setOrigin(RequestConfirmPickUpOriginDTO origin) {
		this.origin = origin;
	}


	public static enum RequestConfirmPickUpOriginDTO {
		
		STORE("STORE"),BOX("BOX");
		
		//private String origin;

		RequestConfirmPickUpOriginDTO(String string) {
			//this.origin = origin;
		}
	}

	@Override
	public String toString() {
		return AppDeliveryUtils.printIdentJSON(this);
	}
	
}
