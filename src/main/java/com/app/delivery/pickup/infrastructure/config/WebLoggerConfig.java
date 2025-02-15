package com.app.delivery.pickup.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

/**
 * @author lmancild
 * @since 1.0.0
 *
 */
@Configuration
public class WebLoggerConfig {

	/**
	 * 
	 * @return
	 */
	@Bean
    public CommonsRequestLoggingFilter logFilter() {
        CommonsRequestLoggingFilter filter = new CommonsRequestLoggingFilter();
        filter.setIncludeQueryString(true);
        filter.setIncludePayload(true);
        filter.setMaxPayloadLength(100000);
        filter.setIncludeHeaders(true);
        filter.setAfterMessagePrefix("[EXPORT CERTIFICATE REQUEST DATA] : ");
        return filter;
    }
}
