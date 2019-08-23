package cn.zsk.notification.service.impl;

import cn.zsk.notification.entity.NotificationTypeEntity;
import cn.zsk.notification.entity.NotificationTypeEnum;
import cn.zsk.notification.entity.RecipientEntity;
import cn.zsk.notification.service.EmailService;
import cn.zsk.notification.service.NotificationTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.text.MessageFormat;

@Service
@RefreshScope
public class EmailServiceImpl implements EmailService {

	private final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private Environment env;

	@Autowired
	private NotificationTypeService notificationTypeService;

	@Override
	public void send(String type, RecipientEntity recipient, String attachment) throws MessagingException, IOException {
		NotificationTypeEntity notificationTypeEntity = notificationTypeService.queryObjByType(type);

		final String subject = env.getProperty(notificationTypeEntity.getSubject());
		final String text = MessageFormat.format(env.getProperty(notificationTypeEntity.getText()), recipient.getAccountName());

		MimeMessage message = mailSender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		helper.setTo(recipient.getEmail());
		helper.setSubject(subject);
		helper.setText(text);

		if (StringUtils.hasLength(attachment)) {
			helper.addAttachment(env.getProperty(notificationTypeEntity.getAttachment()), new ByteArrayResource(attachment.getBytes()));
		}

		mailSender.send(message);

		log.info("{} email notification has been send to {}", type, recipient.getEmail());
	}
}
