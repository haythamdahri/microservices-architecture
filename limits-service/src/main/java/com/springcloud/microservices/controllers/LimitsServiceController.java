package com.springcloud.microservices.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.microservices.beans.LimitConfiguration;
import com.springcloud.microservices.configuration.Configuration;

@RestController
@RequestMapping(path = "")
public class LimitsServiceController {

	// Inject instance of Configuration component class
	@Autowired
	private Configuration configuration;

	@GetMapping(path = "/limits")
	public ResponseEntity<?> retrieveLimitConfig() {
		/*
		 * Retrieve limits service configuration dynamically from application.properties
		 * files using the configuration object
		 */
		return new ResponseEntity<Object>(
				new LimitConfiguration(this.configuration.getMaximum(), this.configuration.getMinimum()),
				HttpStatus.OK);
	}

}
