package cn.zsk.notification.entity;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class NotificationSettings {

	@NotNull
	private Boolean active;

	@NotNull
	private Frequency frequency;

	private Date lastNotified;

}
