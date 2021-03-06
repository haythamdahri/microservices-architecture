package com.springcloud.microservices.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.microservices.entities.CurrencyExchange;
import com.springcloud.microservices.repositories.CurrencyExchangeRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * @author HAYTHAM DAHRI Currency exchange rest controller class
 */
@RestController
@RequestMapping(path = "/currency-exchange")
@Slf4j
public class CurrencyExchangeController {

	/**
	 * Inject environment instance
	 */
	@Autowired
	private Environment environment;

	/**
	 * Inject CurrencyExchangeRepository instance
	 */
	@Autowired
	private CurrencyExchangeRepository currencyExchangeRepository;

	@RequestMapping(path = "/from/{from}/to/{to}", method = RequestMethod.GET)
	public ResponseEntity<CurrencyExchange> getCurrencyExchange(@PathVariable(value = "from") String from,
			@PathVariable(value = "to") String to) {
		CurrencyExchange currencyExchange = this.currencyExchangeRepository
				.findByFromIgnoreCaseAndToIgnoreCase(from, to).orElse(null);
		if (currencyExchange != null) {
			currencyExchange.setPort(Integer.parseInt(this.environment.getProperty("local.server.port")));
		}
		log.info("{}", currencyExchange);
		return new ResponseEntity<>(currencyExchange, HttpStatus.OK);
	}

}
