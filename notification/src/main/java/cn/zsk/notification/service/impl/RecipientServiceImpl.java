package cn.zsk.notification.service.impl;

import cn.zsk.notification.entity.NotificationSettingsEntity;
import cn.zsk.notification.entity.NotificationTypeEntity;
import cn.zsk.notification.entity.NotificationTypeEnum;
import cn.zsk.notification.entity.RecipientEntity;
import cn.zsk.notification.mapper.RecipientMapper;
import cn.zsk.notification.service.NotificationSettingsService;
import cn.zsk.notification.service.NotificationTypeService;
import cn.zsk.notification.service.RecipientService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.*;

@Service
public class RecipientServiceImpl extends ServiceImpl<RecipientMapper,RecipientEntity> implements RecipientService {

	private final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private RecipientMapper recipientMapper;

	@Autowired
	private NotificationSettingsService notificationSettingsService;

	@Autowired
    private NotificationTypeService notificationTypeService;

	@Override
	public RecipientEntity findByAccountName(String accountName) {
		Assert.hasLength(accountName);
		RecipientEntity recipientEntity = recipientMapper.selectOne(new QueryWrapper<RecipientEntity>()
				.eq("account_name",accountName));

		NotificationSettingsEntity notificationSettingsEntity = notificationSettingsService.queryObjById(recipientEntity.getNotificationSettingsId());

        NotificationTypeEntity notificationTypeEntity = notificationTypeService.queryObjById(recipientEntity.getNotificationTypeId());

		Map<NotificationTypeEntity,NotificationSettingsEntity> map = new HashMap<>();
		map.put(notificationTypeEntity,notificationSettingsEntity);
		recipientEntity.setScheduledNotificationMap(map);
		return recipientEntity;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RecipientEntity save(String accountName,String notificationType, NotificationSettingsEntity notificationSettingsEntity) {
        RecipientEntity recipient = new RecipientEntity();
		recipient.setAccountName(accountName);
		if(null == notificationSettingsEntity.getLastNotified()){
		    notificationSettingsEntity.setLastNotified(new Date());
        }

		recipient.setNotificationSettingsId(notificationSettingsService.insertEntity(notificationSettingsEntity));

        NotificationTypeEntity notificationTypeEntity = notificationTypeService.queryObjByType(notificationType);

		if(null != notificationTypeEntity){
            recipient.setNotificationTypeId(notificationTypeEntity.getId());
        }



		recipientMapper.insert(recipient);

		log.info("recipient {} settings has been updated", recipient);

		return recipient;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<RecipientEntity> findReadyToNotify(String type) {
		switch (type) {
			case "backup":
				return recipientMapper.findReadyForBackup();
			case "remind":
				return recipientMapper.findReadyForRemind();
			default:
				throw new IllegalArgumentException();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void markNotified(String notificationType, RecipientEntity recipient) {

        NotificationTypeEntity notificationTypeEntity = notificationTypeService.queryObjByType(notificationType);

        NotificationSettingsEntity notificationSettingsEntity = recipient.getNotificationSettingsEntity();
        notificationSettingsEntity.setLastNotified(new Date());

		recipient.setNotificationSettingsId(notificationSettingsService.insertEntity(notificationSettingsEntity));
		recipient.setNotificationTypeId(notificationTypeEntity.getId());

		recipientMapper.insert(recipient);
	}
}
