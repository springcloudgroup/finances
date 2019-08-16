package cn.zsk.account.client;

import cn.zsk.account.entity.AccountEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author:zsk
 * @CreateTime:2019-08-15 16:46
 */
@FeignClient(name = "statistics", fallback = StatisticsServiceClientFallback.class)
public interface StatisticsServiceClient {

    @RequestMapping(method = RequestMethod.PUT, value = "/statistics/{accountName}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    void updateStatistics(@PathVariable("accountName") String accountName, AccountEntity account);
}
