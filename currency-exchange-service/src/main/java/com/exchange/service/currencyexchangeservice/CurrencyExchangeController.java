package com.exchange.service.currencyexchangeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {	
	
	@Autowired
	private Environment environment;
	
	@Autowired
	CurrencyExchangeRepository repository;
	
	@GetMapping("curency-exchange/from/{from}/to/{to}")
	public ExchangeValue currencyExchange(@PathVariable("from")String from,
			@PathVariable("to")String to) {
				
		ExchangeValue exchangeValue = repository.findByFromCurrencyAndToCurrency(from, to);		
		exchangeValue.setPort(
				Integer.parseInt(environment.getProperty("local.server.port")));
		return exchangeValue;
	}
	
}
