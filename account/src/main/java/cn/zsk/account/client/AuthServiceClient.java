package cn.zsk.account.client;

import cn.zsk.account.entity.UserEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author:zsk
 * @CreateTime:2019-08-15 15:49
 */
@FeignClient(name = "auth")
public interface AuthServiceClient {

    @RequestMapping(method = RequestMethod.POST, value = "/uaa/users", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    void createUser(UserEntity user);
}
