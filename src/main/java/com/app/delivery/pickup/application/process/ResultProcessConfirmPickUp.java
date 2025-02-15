package com.app.delivery.pickup.application.process;

import java.util.List;

/**
 * 
 * @author lmancild
 * @since 1.0.0
 */
public class ResultProcessConfirmPickUp {

	private boolean process;
	private String clientId;
	private String purchaseCode;
	private List<ResultProcessConfirmPickUpError> errors;

	/**
	 * 
	 * @param builder
	 */
	public ResultProcessConfirmPickUp(Builder builder) {
		this.process = builder.process;
		this.clientId = builder.clientId;
		this.purchaseCode = builder.purchaseCode;
		this.errors = builder.errors;
	}

	
	@Override
	public String toString() {
		StringBuilder b = new StringBuilder();
		b.append("\n");
		b.append("IS PROCESS        : ");
		b.append(this.process);
		b.append("\n");
		b.append("CLIENT ID         : ");
		b.append(this.clientId);
		b.append("\n");
		b.append("PURCHASE CODE     : ");
		b.append(this.purchaseCode);
		b.append("\n");
		return b.toString();
	}
	
	
	
	
	public boolean isProcess() {
		return process;
	}


	public String getClientId() {
		return clientId;
	}


	public String getPurchaseCode() {
		return purchaseCode;
	}


	public List<ResultProcessConfirmPickUpError> getErrors() {
		return errors;
	}

	public static class ResultProcessConfirmPickUpError {
		
		private String errorCode;
		private String errorDescription;
		
		public ResultProcessConfirmPickUpError(String errorCode, String errorDescription) {
			super();
			this.errorCode = errorCode;
			this.errorDescription = errorDescription;
		}

		public String getErrorCode() {
			return errorCode;
		}

		public String getErrorDescription() {
			return errorDescription;
		}
	}
	
	public static class Builder {

		private boolean process;
		private String clientId;
		private String purchaseCode;
		private List<ResultProcessConfirmPickUpError> errors;

		public Builder(boolean process) {
			this.process = process;
		}
		
		public Builder clientId(String clientId) {
			this.clientId = clientId;
			return this;
		}
		
		public Builder purchaseCode(String purchaseCode) {
			this.purchaseCode = purchaseCode;
			return this;
		}
		
		public Builder errors(List<ResultProcessConfirmPickUpError> errors) {
			this.errors = errors;
			return this;
		}
		
		public ResultProcessConfirmPickUp build() {
			return new ResultProcessConfirmPickUp(this);
		}
	}
}
