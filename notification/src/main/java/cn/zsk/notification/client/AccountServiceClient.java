package cn.zsk.notification.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author:zsk
 * @CreateTime:2019-08-15 16:57
 */
@FeignClient(name = "account")
public interface AccountServiceClient {

    @RequestMapping(method = RequestMethod.GET, value = "/accounts/{accountName}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    String getAccount(@PathVariable("accountName") String accountName);
}
