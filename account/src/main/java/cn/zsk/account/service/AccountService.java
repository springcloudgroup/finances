package cn.zsk.account.service;

import cn.zsk.account.entity.AccountEntity;
import cn.zsk.account.entity.UserEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import io.undertow.security.idm.Account;

/**
 * @author:zsk
 * @CreateTime:2019-08-12 15:25
 */
public interface AccountService extends IService<AccountEntity> {
    /**
     * Finds account by given name
     *
     * @param accountName
     * @return found account
     */
    AccountEntity findByName(String accountName);

    /**
     * Checks if account with the same name already exists
     * Invokes Auth Service user creation
     * Creates new account with default parameters
     *
     * @param user
     * @return created account
     */
    AccountEntity create(UserEntity user);

    /**
     * Validates and applies incoming account updates
     * Invokes Statistics Service update
     *
     * @param name
     * @param update
     */
    void saveChanges(String name, Account update);
}
