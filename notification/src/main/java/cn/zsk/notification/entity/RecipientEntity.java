package cn.zsk.notification.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Map;

@Data
@TableName("recipient")
public class RecipientEntity {

	@TableId("account_name")
	private String accountName;

	@TableField("email")
	private String email;

	@TableField("notification_type_id")
	private Integer notificationTypeId;

	@TableField("notification_settings_id")
	private Integer notificationSettingsId;

	@TableField(exist = false)
    private Map<NotificationTypeEntity,NotificationSettingsEntity> scheduledNotificationMap;

	@TableField(exist = false)
	private NotificationSettingsEntity notificationSettingsEntity;

}
