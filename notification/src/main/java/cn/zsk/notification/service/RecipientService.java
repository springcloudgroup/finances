package cn.zsk.notification.service;



import cn.zsk.notification.entity.NotificationSettingsEntity;
import cn.zsk.notification.entity.NotificationTypeEnum;
import cn.zsk.notification.entity.RecipientEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface RecipientService extends IService<RecipientEntity> {

	/**
	 * Finds recipient by account name
	 *
	 * @param accountName
	 * @return recipient
	 */
	RecipientEntity findByAccountName(String accountName);

	/**
	 * Finds recipients, which are ready to be notified
	 * at the moment
	 *
	 * @param type
	 * @return recipients to notify
	 */
	List<RecipientEntity> findReadyToNotify(String type);

	/**
	 * Creates or updates recipient settings
	 *
	 * @param accountName
	 * @param notificationSettings
	 * @return updated recipient
	 */
	RecipientEntity save(String accountName,String notificationType, NotificationSettingsEntity notificationSettings);

	/**
	 * @param notificationType
	 * @param recipient
	 */
	void markNotified(String notificationType, RecipientEntity recipient);
}
