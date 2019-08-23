package cn.zsk.notification.service;

import cn.zsk.notification.entity.NotificationTypeEntity;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author:zsk
 * @CreateTime:2019-08-23 14:15
 */
public interface NotificationTypeService extends IService<NotificationTypeEntity> {

    //通过type查询
    NotificationTypeEntity queryObjByType(String type);

    //通过id查询
    NotificationTypeEntity queryObjById(Integer id);

}
