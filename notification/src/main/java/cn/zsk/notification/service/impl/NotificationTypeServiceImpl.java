package cn.zsk.notification.service.impl;

import cn.zsk.notification.entity.NotificationTypeEntity;
import cn.zsk.notification.mapper.NotificationTypeMapper;
import cn.zsk.notification.service.NotificationTypeService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author:zsk
 * @CreateTime:2019-08-23 14:17
 */
@Service
public class NotificationTypeServiceImpl extends ServiceImpl<NotificationTypeMapper, NotificationTypeEntity> implements NotificationTypeService {
    @Autowired
    private NotificationTypeMapper notificationTypeMapper;

    @Override
    public NotificationTypeEntity queryObjByType(String type) {
        return notificationTypeMapper.selectOne(new QueryWrapper<NotificationTypeEntity>().eq("type",type));
    }

    @Override
    public NotificationTypeEntity queryObjById(Integer id) {
        return notificationTypeMapper.selectById(id);
    }
}
