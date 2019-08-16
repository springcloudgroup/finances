package cn.zsk.authservice.controller;

import cn.zsk.authservice.entity.UserEntity;
import cn.zsk.authservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

/**
 * @author:zsk
 * @CreateTime:2019-08-14 15:55
 */
@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/current", method = RequestMethod.GET)
    public Principal getUser(Principal principal) {
        return principal;
    }

    @PostMapping()
    public void createUser(UserEntity userEntity){
        userService.create(userEntity);
    }
}
