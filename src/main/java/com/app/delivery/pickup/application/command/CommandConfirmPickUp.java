package com.app.delivery.pickup.application.command;

import java.util.Date;

/**
 * @author lmancild
 * @since 1.0.0
 *
 */
public class CommandConfirmPickUp {

	private String purchaseCode;
	private String pruchaseStatus;
	private Date pickUpDate;
	
	
	public String getPurchaseCode() {
		return purchaseCode;
	}
	public String getPruchaseStatus() {
		return pruchaseStatus;
	}
	public void setPurchaseCode(String purchaseCode) {
		this.purchaseCode = purchaseCode;
	}
	public void setPruchaseStatus(String pruchaseStatus) {
		this.pruchaseStatus = pruchaseStatus;
	}
	public Date getPickUpDate() {
		return pickUpDate;
	}
	public void setPickUpDate(Date pickUpDate) {
		this.pickUpDate = pickUpDate;
	}
	
	
	
	
}
