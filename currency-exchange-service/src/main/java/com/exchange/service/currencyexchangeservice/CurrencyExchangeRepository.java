package com.exchange.service.currencyexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyExchangeRepository extends JpaRepository<ExchangeValue, Long> {

	ExchangeValue findByFromCurrencyAndToCurrency(String from,String to);
}
