package cn.zsk.statistics.service;

import cn.zsk.statistics.entity.CurrencyEnum;

import java.math.BigDecimal;
import java.util.Map;

public interface ExchangeRatesService {

	/**
	 * Requests today's foreign exchange rates from a provider
	 * or reuses values from the last request (if they are still relevant)
	 *
	 * @return current date rates
	 */
	Map<CurrencyEnum, BigDecimal> getCurrentRates();

	/**
	 * Converts given amount to specified currency
	 *
	 * @param from {@link CurrencyEnum}
	 * @param to {@link CurrencyEnum}
	 * @param amount to be converted
	 * @return converted amount
	 */
	BigDecimal convert(CurrencyEnum from, CurrencyEnum to, BigDecimal amount);
}
