package cn.zsk.account.service.impl;

import cn.zsk.account.entity.AccountEntity;
import cn.zsk.account.entity.UserEntity;
import cn.zsk.account.mapper.AccountMapper;
import cn.zsk.account.service.AccountService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.undertow.security.idm.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author:zsk
 * @CreateTime:2019-08-12 15:26
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, AccountEntity> implements AccountService {
    @Autowired
    private AccountMapper accountMapper;

    @Override
    public AccountEntity findByName(String accountName) {
        return accountMapper.selectById(new QueryWrapper<AccountEntity>()
                .eq("name",accountName));
    }

    @Override
    public AccountEntity create(UserEntity user) {
        return null;
    }

    @Override
    public void saveChanges(String name, Account update) {

    }
}
