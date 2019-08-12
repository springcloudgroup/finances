package cn.zsk.authservice.mapper;

import cn.zsk.authservice.entity.UserEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author:zsk
 * @CreateTime:2019-08-12 16:49
 */
@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {

}
