package cn.zsk.statistics.client;

import cn.zsk.statistics.entity.Currency;
import cn.zsk.statistics.entity.ExchangeRatesContainer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author:zsk
 * @CreateTime:2019-08-16 09:36
 */
@FeignClient(url = "${rates.url}",name = "rates-client",fallback = ExchangeRatesClientFallback.class)
public interface ExchangeRatesClient {

    @RequestMapping(method = RequestMethod.GET, value = "/latest")
    ExchangeRatesContainer getRates(@RequestParam("base") Currency base);
}
