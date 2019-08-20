package cn.zsk.notification.mapper;

import cn.zsk.notification.entity.Recipient;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author:zsk
 * @CreateTime:2019-08-15 17:15
 */
@Mapper
public interface RecipientMapper {

    Recipient findByAccountName(String name);

    List<Recipient> findReadyForBackup();

    List<Recipient> findReadyForRemind();

    void save(Recipient recipient);

}
