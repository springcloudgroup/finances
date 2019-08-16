package cn.zsk.notification.service;

import cn.zsk.notification.entity.NotificationType;
import cn.zsk.notification.entity.Recipient;

import javax.mail.MessagingException;
import java.io.IOException;

public interface EmailService {

	void send(NotificationType type, Recipient recipient, String attachment) throws MessagingException, IOException;

}
