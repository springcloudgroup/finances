package cn.zsk.notification.service.impl;

import cn.zsk.notification.entity.NotificationSettingsEntity;
import cn.zsk.notification.entity.NotificationTypeEnum;
import cn.zsk.notification.entity.RecipientEntity;
import cn.zsk.notification.mapper.RecipientMapper;
import cn.zsk.notification.service.NotificationSettingsService;
import cn.zsk.notification.service.RecipientService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.QueryChainWrapper;
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

	@Override
	public RecipientEntity findByAccountName(String accountName) {
		Assert.hasLength(accountName);
		RecipientEntity recipientEntity = recipientMapper.selectOne(new QueryWrapper<RecipientEntity>()
				.eq("account_name",accountName));
		NotificationSettingsEntity notificationSettingsEntity = notificationSettingsService.getOne(new QueryWrapper<NotificationSettingsEntity>()
				.eq("id",recipientEntity.getNotificationSettingsId()));
		Map<NotificationTypeEnum,NotificationSettingsEntity> map = new HashMap<>();
//		map.put(recipientEntity.getNotificationType(),notificationSettingsEntity);
//		recipientEntity.setScheduledNotifications();
		return recipientMapper.findByAccountName(accountName);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RecipientEntity save(String accountName, RecipientEntity recipient) {

		recipient.setAccountName(accountName);
		recipient.getScheduledNotifications().values()
				.forEach(settings -> {
					if (settings.getLastNotified() == null) {
						settings.setLastNotified(new Date());
					}
				});

		List<NotificationSettingsEntity> notificationSettingsEntityList = new ArrayList<NotificationSettingsEntity>(recipient.getScheduledNotifications().values());
		NotificationSettingsEntity notificationSettingsEntity = notificationSettingsEntityList.get(0);

		recipient.setNotificationSettingsId(notificationSettingsService.insertEntity(notificationSettingsEntity));


		recipientMapper.save(recipient);

		log.info("recipient {} settings has been updated", recipient);

		return recipient;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<RecipientEntity> findReadyToNotify(NotificationTypeEnum type) {
		switch (type) {
			case BACKUP:
				return recipientMapper.findReadyForBackup();
			case REMIND:
				return recipientMapper.findReadyForRemind();
			default:
				throw new IllegalArgumentException();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void markNotified(NotificationTypeEnum type, RecipientEntity recipient) {
		recipient.getScheduledNotifications().get(type).setLastNotified(new Date());

		List<NotificationSettingsEntity> notificationSettingsEntityList = new ArrayList<NotificationSettingsEntity>(recipient.getScheduledNotifications().values());
		List<NotificationTypeEnum> notificationTypeEnumList = new ArrayList<NotificationTypeEnum>(recipient.getScheduledNotifications().keySet());
		NotificationSettingsEntity notificationSettingsEntity = notificationSettingsEntityList.get(0);
		NotificationTypeEnum notificationTypeEnum = notificationTypeEnumList.get(0);

		recipient.setNotificationSettingsId(notificationSettingsService.insertEntity(notificationSettingsEntity));
		recipient.setNotificationType(notificationTypeEnum.toString());

		recipientMapper.save(recipient);
	}
}
