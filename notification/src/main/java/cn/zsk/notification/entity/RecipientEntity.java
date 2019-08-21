package cn.zsk.notification.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.Valid;
import java.util.Map;

@Data
@TableName("recipient")
public class RecipientEntity {

	@TableId("account_name")
	private String accountName;

	@TableField("email")
	private String email;

	@TableField("notification_type")
	private String notificationType;

	@TableField("notification_settings_id")
	private Integer notificationSettingsId;

	@Valid
	private Map<NotificationTypeEnum, NotificationSettingsEntity> scheduledNotifications;



	@Override
	public String toString() {
		return "Recipient{" +
				"accountName='" + accountName + '\'' +
				", email='" + email + '\'' +
				'}';
	}
}
