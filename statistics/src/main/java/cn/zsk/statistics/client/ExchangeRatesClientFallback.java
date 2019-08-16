package cn.zsk.statistics.client;

import cn.zsk.statistics.entity.Currency;
import cn.zsk.statistics.entity.ExchangeRatesContainer;
import org.springframework.stereotype.Component;

import java.util.Collections;

/**
 * @author:zsk
 * @CreateTime:2019-08-16 09:38
 */
@Component
public class ExchangeRatesClientFallback implements ExchangeRatesClient{

    @Override
    public ExchangeRatesContainer getRates(cn.zsk.statistics.entity.Currency base) {
        ExchangeRatesContainer container = new ExchangeRatesContainer();
        container.setBase(Currency.getBase());
        container.setRates(Collections.emptyMap());
        return container;
    }
}
