package com.springcloud.microservices.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "currency_exchanges")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyExchange {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "from_exchange")
	private String from;

	@Column(name = "to_exchange")
	private String to;
	
	@Column(name = "conversion_multiple")
	private BigDecimal conversionMultiple;

	@Column(name = "port")
	private int port;
	
	
}
