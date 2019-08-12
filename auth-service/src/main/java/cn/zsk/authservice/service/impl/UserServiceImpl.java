package cn.zsk.authservice.service.impl;

import cn.zsk.authservice.entity.UserEntity;
import cn.zsk.authservice.mapper.UserMapper;
import cn.zsk.authservice.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author:zsk
 * @CreateTime:2019-08-12 16:50
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Autowired
    private UserMapper userMapper;


    @Override
    public void create(UserEntity user) {
        Optional<UserEntity> existing = Optional.ofNullable(userMapper.selectById(new QueryWrapper<UserEntity>()
                .eq("user_name", user.getUserName())));
        existing.ifPresent(it-> {throw new IllegalArgumentException("user already exists: " + it.getUserName());});

        String hash = encoder.encode(user.getPassword());
        user.setPassword(hash);

        userMapper.insert(user);

        logger.info("new user has been created: {}", user.getUserName());
    }
}
