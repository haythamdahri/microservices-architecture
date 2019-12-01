package com.springcloud.microservices.controllers;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.springcloud.microservices.models.CurrencyConversionBean;
import com.springcloud.microservices.proxies.CurrencyEchangeServiceProxy;

/**
 * @author HAYTHAM DAHRI Currency conversion rest controller
 */
@RestController
@RequestMapping(path = "/currency-converter")
public class CurrencyConversionController {
	
	private static final String currencyExchangeMicroservice = "http://localhost:8000/currency-exchange/from/{from}/to/{to}";
	
	@Autowired
	private CurrencyEchangeServiceProxy currencyEchangeServiceProxy;
	
	/**
	 * Method to invoke the other microservice 
	 */
	@RequestMapping(path = "old/from/{from}/to/{to}/quantity/{quantity}", method = RequestMethod.GET)
	public ResponseEntity<CurrencyConversionBean> convertCurrency(@PathVariable(value = "from") String from,
			@PathVariable(value = "to") String to, @PathVariable(value = "quantity") BigDecimal quantity) {
		
		// Invoke Currency Exchange Microservice
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<CurrencyConversionBean> currencyConversionBeanResponse = restTemplate.getForEntity(currencyExchangeMicroservice, CurrencyConversionBean.class, uriVariables);
		
		CurrencyConversionBean currencyConversionBean = currencyConversionBeanResponse.getBody();
		currencyConversionBean.setQuantity(quantity);
		
		// Calculate total Amount
		currencyConversionBean.calculateTotalAmount();
		
		// Return http response
		return new ResponseEntity<CurrencyConversionBean>(currencyConversionBean, HttpStatus.OK);
	}
	
	/**
	 * Method to invoke the other microservice using feign client proxy 
	 */
	@RequestMapping(path = "/from/{from}/to/{to}/quantity/{quantity}", method = RequestMethod.GET)
	public ResponseEntity<CurrencyConversionBean> convertCurrencyUsingProxy(@PathVariable(value = "from") String from,
			@PathVariable(value = "to") String to, @PathVariable(value = "quantity") BigDecimal quantity) {
		
		CurrencyConversionBean currencyConversionBean = this.currencyEchangeServiceProxy.getCurrencyExchange(from, to).getBody();
		currencyConversionBean.setQuantity(quantity);
		
		// Calculate total Amount
		currencyConversionBean.calculateTotalAmount();
		
		// Return http response
		return new ResponseEntity<CurrencyConversionBean>(currencyConversionBean, HttpStatus.OK);
	}

}
