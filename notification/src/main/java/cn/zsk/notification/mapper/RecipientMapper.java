package cn.zsk.notification.mapper;

import cn.zsk.notification.entity.RecipientEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author:zsk
 * @CreateTime:2019-08-15 17:15
 */
@Mapper
public interface RecipientMapper extends BaseMapper<RecipientEntity> {

    List<RecipientEntity> findReadyForBackup();

    List<RecipientEntity> findReadyForRemind();

}
