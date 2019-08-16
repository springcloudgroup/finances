package cn.zsk.notification.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.springframework.data.annotation.Id;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Map;

@Data
public class Recipient {

	@Id
	private String accountName;

	@NotNull
	@Email
	private String email;

	@Valid
	private Map<NotificationType, NotificationSettings> scheduledNotifications;



	@Override
	public String toString() {
		return "Recipient{" +
				"accountName='" + accountName + '\'' +
				", email='" + email + '\'' +
				'}';
	}
}
