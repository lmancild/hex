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
public class ResponseBaseDTO {

	private Date timestamp;
	private String status;
	private String path;
	private Object data;
	private List<ResponseBaseErrorDTO> errors;
	
	public ResponseBaseDTO(Builder builder) {
		this.timestamp = builder.timestamp;
		this.status = builder.status;
		this.path = builder.path;
		this.data = builder.data;
		this.errors = builder.errors;
	}

	
	
	public Date getTimestamp() {
		return timestamp;
	}
	
	public String getStatus() {
		return status;
	}
	
	public String getPath() {
		return path;
	}
	
	public Object getData() {
		return data;
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
		private String path;
		private Object data;
		private List<ResponseBaseErrorDTO> errors;

		public Builder(String status) {
			this.status = status;
			this.timestamp = new Date();
		}

		public Builder path(String path) {
			this.path = path;
			return this;
		}

		public Builder data(Object data) {
			this.data = data;
			return this;
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
		
		public ResponseBaseDTO build() {
			return new ResponseBaseDTO(this);
		}

	}

}
