package com.conversion.service.currencyconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {

	private static final String URL = "http://localhost:8000/curency-exchange/from/{from}/to/{to}";;

	@Autowired
	CurrencyExchangeServiceProxy proxy;
	
	@GetMapping("/currency-conversion/from/{from}/to/{to}/qty/{qty}")
	public ConversionValue currencyConversion(
			@PathVariable("from")String from,
			@PathVariable("to")String to,
			@PathVariable("qty")BigDecimal qty) {
		
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		
		ResponseEntity<ConversionValue> responseEntity = new RestTemplate()
				.getForEntity(URL, ConversionValue.class, uriVariables);
		ConversionValue cv = responseEntity.getBody();
		cv.setCalculatedValue( qty.multiply(cv.getConversionValue()) );
		
		return cv;
	}
	
	@GetMapping("/currency-conversion-feign/from/{from}/to/{to}/qty/{qty}")
	public ConversionValue currencyConversionUsingFeign(
			@PathVariable("from")String from,
			@PathVariable("to")String to,
			@PathVariable("qty")BigDecimal qty) {
		
		ConversionValue cv = proxy.currencyExchange(from, to);
		cv.setCalculatedValue( qty.multiply(cv.getConversionValue()) );
		
		return cv;
	}
	
}
