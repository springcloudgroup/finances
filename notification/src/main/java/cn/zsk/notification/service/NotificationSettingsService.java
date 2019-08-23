package cn.zsk.notification.service;

import cn.zsk.notification.entity.NotificationSettingsEntity;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author:zsk
 * @CreateTime:2019-08-21 14:56
 */
public interface NotificationSettingsService extends IService<NotificationSettingsEntity> {

    //通过id查询
    NotificationSettingsEntity queryObjById(Integer id);

    Integer insertEntity(NotificationSettingsEntity notificationSettingsEntity);
}
