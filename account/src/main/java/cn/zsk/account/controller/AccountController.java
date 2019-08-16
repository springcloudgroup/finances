package cn.zsk.account.controller;

import cn.zsk.account.entity.AccountEntity;
import cn.zsk.account.entity.UserEntity;
import cn.zsk.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

/**
 * @author:zsk
 * @CreateTime:2019-08-14 17:43
 */
@RestController
public class AccountController {
    @Autowired
    private AccountService accountService;

    @RequestMapping(path = "/{name}", method = RequestMethod.GET)
    public AccountEntity getAccountByName(@PathVariable String name) {
        return accountService.findByName(name);
    }

    @RequestMapping(path = "/current", method = RequestMethod.PUT)
    public void saveCurrentAccount(Principal principal, @RequestBody AccountEntity account) {
        accountService.saveChanges(principal.getName(), account);
    }

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public AccountEntity createNewAccount(@RequestBody UserEntity user) {
        return accountService.create(user);
    }
}
