package cn.zsk.notification.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@TableName("notification_settings")
public class NotificationSettingsEntity {

	@TableId
	private Integer id;

	@NotNull
	private Boolean active;

	@NotNull
	private FrequencyEnum frequency;

	private Date lastNotified;

}
