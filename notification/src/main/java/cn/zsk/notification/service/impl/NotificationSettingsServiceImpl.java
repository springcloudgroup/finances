package cn.zsk.notification.service.impl;

import cn.zsk.notification.entity.NotificationSettingsEntity;
import cn.zsk.notification.mapper.NotificationSettingsMapper;
import cn.zsk.notification.service.NotificationSettingsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author:zsk
 * @CreateTime:2019-08-21 14:57
 */
@Service
public class NotificationSettingsServiceImpl extends ServiceImpl<NotificationSettingsMapper, NotificationSettingsEntity> implements NotificationSettingsService {
    @Autowired
    private NotificationSettingsMapper notificationSettingsMapper;

    @Override
    public NotificationSettingsEntity queryObjById(Integer id) {
        return notificationSettingsMapper.selectById(id);
    }

    @Override
    public Integer insertEntity(NotificationSettingsEntity notificationSettingsEntity) {
        notificationSettingsMapper.insert(notificationSettingsEntity);
        return notificationSettingsEntity.getId();
    }
}
