package cn.zsk.statistics.service.impl;

import cn.zsk.statistics.client.ExchangeRatesClient;
import cn.zsk.statistics.entity.CurrencyEnum;
import cn.zsk.statistics.entity.ExchangeRatesContainer;
import cn.zsk.statistics.service.ExchangeRatesService;
import com.google.common.collect.ImmutableMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Map;

@Service
public class ExchangeRatesServiceImpl implements ExchangeRatesService {

	private static final Logger log = LoggerFactory.getLogger(ExchangeRatesServiceImpl.class);

	private ExchangeRatesContainer container;

	@Autowired
	private ExchangeRatesClient client;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<CurrencyEnum, BigDecimal> getCurrentRates() {

		if (container == null || !container.getDate().equals(LocalDate.now())) {
			container = client.getRates(CurrencyEnum.getBase());
			log.info("exchange rates has been updated: {}", container);
		}

		return ImmutableMap.of(
				CurrencyEnum.EUR, container.getRates().get(CurrencyEnum.EUR.name()),
				CurrencyEnum.RUB, container.getRates().get(CurrencyEnum.RUB.name()),
				CurrencyEnum.USD, BigDecimal.ONE
		);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BigDecimal convert(CurrencyEnum from, CurrencyEnum to, BigDecimal amount) {

		Assert.notNull(amount);

		Map<CurrencyEnum, BigDecimal> rates = getCurrentRates();
		BigDecimal ratio = rates.get(to).divide(rates.get(from), 4, RoundingMode.HALF_UP);

		return amount.multiply(ratio);
	}
}
