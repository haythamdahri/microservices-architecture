package com.springcloud.microservices.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
// Bind external properties (ex: application.properties file ...)
@ConfigurationProperties(value = "limits-service")
public class Configuration {

	// Variable matchs maximum property in application.properties => limits-service.maximum
	private int maximum;

	// Variable matchs maximum property in application.properties => limits-service.minimum
	private int minimum;
}
