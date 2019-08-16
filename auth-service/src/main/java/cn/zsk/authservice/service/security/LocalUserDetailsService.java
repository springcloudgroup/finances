package cn.zsk.authservice.service.security;

import cn.zsk.authservice.entity.UserEntity;
import cn.zsk.authservice.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author:zsk
 * @CreateTime:2019-08-14 16:11
 */
@Service
public class LocalUserDetailsService implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<UserEntity> userEntity = Optional.ofNullable(userMapper.selectById(username));

        return userEntity.orElseThrow(()->new UsernameNotFoundException(username));
    }
}
