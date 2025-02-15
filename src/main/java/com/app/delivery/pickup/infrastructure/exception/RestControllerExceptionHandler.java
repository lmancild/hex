package com.app.delivery.pickup.infrastructure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.app.delivery.pickup.infrastructure.dto.response.ResponseBaseDTO;
import com.app.delivery.pickup.infrastructure.dto.response.ResponseBaseDTO.ResponseBaseErrorDTO;

/**
 * 
 * @author lmancild
 * @version 1.0.0
 * @since 1.0.0
 */
@ControllerAdvice
public class RestControllerExceptionHandler {

	/**
	 * Exception handler for MethodArgumentNotValidException
	 * @param ex
	 * @param request
	 * @return
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseBaseDTO> resourceNotFoundException(MethodArgumentNotValidException ex,
			WebRequest request) {
		
		ResponseBaseDTO.Builder response = new ResponseBaseDTO.Builder("ERROR");
		if(ex.getAllErrors() != null && !ex.getAllErrors().isEmpty()){
			ex.getAllErrors().forEach(e -> {
				response.error(new ResponseBaseErrorDTO(e.getObjectName(), e.getDefaultMessage()));	
			});
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response.build());
	}

}