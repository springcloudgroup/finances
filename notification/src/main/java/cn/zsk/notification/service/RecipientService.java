package cn.zsk.notification.service;



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
	List<RecipientEntity> findReadyToNotify(NotificationTypeEnum type);

	/**
	 * Creates or updates recipient settings
	 *
	 * @param accountName
	 * @param recipient
	 * @return updated recipient
	 */
	RecipientEntity save(String accountName, RecipientEntity recipient);

	/**
	 * Updates {@link NotificationTypeEnum} {@code lastNotified} property with current date
	 * for given recipient.
	 *
	 * @param type
	 * @param recipient
	 */
	void markNotified(NotificationTypeEnum type, RecipientEntity recipient);
}
