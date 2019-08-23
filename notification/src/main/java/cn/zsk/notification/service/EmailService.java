package cn.zsk.notification.service;

import cn.zsk.notification.entity.NotificationTypeEnum;
import cn.zsk.notification.entity.RecipientEntity;

import javax.mail.MessagingException;
import java.io.IOException;

public interface EmailService {

	void send(String type, RecipientEntity recipient, String attachment) throws MessagingException, IOException;

}
