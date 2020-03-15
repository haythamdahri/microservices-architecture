package com.springcloud.microservices.proxies;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springcloud.microservices.models.CurrencyConversionBean;

/**
 * @author HAYTHAM DAHRI
 * Proxy client to invoke an other microservice 
 * feign client name property must much the application name of the microservice to invoke
 */
//@FeignClient(name = "currenc-exchange-service", url="http://localhost:8000")
/**
 * No need to specify the microservice instance to talk to while we have different ones with different ports 
 * RibbonClient must receive same name as the microservice wich we want to talk to
 * Specify list of servers to send the request to
 */
@FeignClient(name = "netflix-zuul-api-gateway")
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyEchangeServiceProxy {
	
	/**
	 * Method to talk to currency exchange microservice 
	 * The method must much the one in the controller from the invoked microservice
	 */
	@RequestMapping(path = "/currency-exchange-service/currency-exchange/from/{from}/to/{to}", method=RequestMethod.GET)
	public ResponseEntity<CurrencyConversionBean> getCurrencyExchange(@PathVariable(value = "from") String from,
			@PathVariable(value = "to") String to); 

}
