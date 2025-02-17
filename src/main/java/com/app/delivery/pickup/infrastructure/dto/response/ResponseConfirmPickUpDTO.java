package com.app.delivery.pickup.infrastructure.dto.response;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.app.delivery.pickup.application.utils.AppDeliveryUtils;
import com.fasterxml.jackson.annotation.JsonInclude;


/**
 * @author lmancild
 * @since 1.0.0
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseConfirmPickUpDTO {

	private Date timestamp;
	private String status;
	private List<ResponseBaseErrorDTO> errors;
	
	public ResponseConfirmPickUpDTO(Builder builder) {
		this.timestamp = builder.timestamp;
		this.status = builder.status;
		this.errors = builder.errors;
	}

	
	
	public Date getTimestamp() {
		return timestamp;
	}
	
	public String getStatus() {
		return status;
	}
	
	public List<ResponseBaseErrorDTO> getErrors() {
		return errors;
	}

	@Override
	public String toString() {
		return AppDeliveryUtils.printIdentJSON(this);
	}

	public static class ResponseBaseErrorDTO {

		private String errorCode;
		private String errorDescription;
		/**
		 * 
		 * @param errorCode
		 * @param errorDescription
		 */
		public ResponseBaseErrorDTO(String errorCode, String errorDescription) {
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

		private Date timestamp;
		private String status;
		private List<ResponseBaseErrorDTO> errors;

		public Builder(String status) {
			this.status = status;
			this.timestamp = new Date();
		}

		public Builder errors(List<ResponseBaseErrorDTO> errors) {
			this.errors = errors;
			return this;
		}
		
		
		public Builder error(ResponseBaseErrorDTO error) {
			if(errors == null)
				this.errors = new ArrayList<>();
			errors.add(error);
			return this;
		}
		
		public ResponseConfirmPickUpDTO build() {
			return new ResponseConfirmPickUpDTO(this);
		}

	}

}
