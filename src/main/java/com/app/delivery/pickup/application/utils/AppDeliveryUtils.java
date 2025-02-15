package com.app.delivery.pickup.application.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * @author lmancild
 * @since 1.0.0
 *
 */
public class AppDeliveryUtils {

	private static final Logger log = LoggerFactory.getLogger(AppDeliveryUtils.class);
	private static final ObjectMapper mapper = new ObjectMapper();

	static {
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
	}

	/**
	 * 
	 * @param json
	 * @return
	 */
	public static String printIdentJSON(Object json) {
		try {
			return mapper.writeValueAsString(json);
		} catch (JsonProcessingException e) {
			log.error("Error to format json", e);
		}
		return "";
	}

	
	/**
	 * 
	 * @param <T>
	 * @param json
	 * @param clazz
	 * @return
	 */
	public static <T> T jsonToObject(String json, Class<T> clazz) {
		try {
			return mapper.readValue(json, clazz);
		} catch (JsonProcessingException e) {
			log.error("Error tranform json to object", e);
		}
		return null;
	}
}
