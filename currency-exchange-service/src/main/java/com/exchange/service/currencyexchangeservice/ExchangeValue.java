package com.exchange.service.currencyexchangeservice;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="exchange_value")
public class ExchangeValue {

	@Id
	private Long id;
	
	@Column(name="FROMCURRENCY")
	private String fromCurrency;
	@Column(name="TOCURRENCY")
	private String toCurrency;
	private Integer port;
	
	@Column(name="CONVERSIONVALUE")
	private BigDecimal conversionValue;

	public String getFromCurrency() {
		return fromCurrency;
	}

	public void setFromCurrency(String fromCurrency) {
		this.fromCurrency = fromCurrency;
	}

	public String getToCurrency() {
		return toCurrency;
	}

	public void setToCurrency(String toCurrency) {
		this.toCurrency = toCurrency;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public BigDecimal getConversionValue() {
		return conversionValue;
	}

	public void setConversionValue(BigDecimal conversionValue) {
		this.conversionValue = conversionValue;
	}

}
