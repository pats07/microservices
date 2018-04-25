package com.conversion.service.currencyconversionservice;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="currency-exchange-service", url="localhost:8000")
public interface CurrencyExchangeServiceProxy {

	@GetMapping("curency-exchange/from/{from}/to/{to}")
	public ConversionValue currencyExchange(@PathVariable("from")String from,
			@PathVariable("to")String to);
}
