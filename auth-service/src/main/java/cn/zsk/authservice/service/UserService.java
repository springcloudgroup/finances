package cn.zsk.authservice.service;

import cn.zsk.authservice.entity.UserEntity;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author:zsk
 * @CreateTime:2019-08-12 16:50
 */
public interface UserService extends IService<UserEntity> {

    void create(UserEntity user);
}
