package com.springcloud.microservices.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springcloud.microservices.entities.CurrencyExchange;

@Repository
public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long>{

	/**
	 * Custom DAO method to retrieve currency exchange based on two attributes: from , to 
	 */
	Optional<CurrencyExchange> findByFromIgnoreCaseAndToIgnoreCase(@Param(value = "from") String from, @Param(value = "to") String to);
	
}
