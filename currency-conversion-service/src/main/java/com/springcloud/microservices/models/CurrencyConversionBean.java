package com.springcloud.microservices.models;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyConversionBean {

	private Long id;
	private String from;
	private String to;
	private BigDecimal conversionMultiple;
	private BigDecimal quantity;
	private BigDecimal totalCalculatedAmount;
	private int port;
	
	
	/**
	 * Calculate total amount method 
	 */
	public void calculateTotalAmount() {
		this.totalCalculatedAmount = this.quantity.multiply(this.conversionMultiple);
	}
	
}
