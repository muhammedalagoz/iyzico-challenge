package com.iyzico.challenge.mail;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import com.iyzico.challenge.entity.Ticket;

@Service
public class TicketMailService {
	private Logger logger = Logger.getLogger(TicketMailService.class);

	@Autowired
	private JavaMailSenderImpl mailSender;
	@Autowired
	private TicketMailContentBuilder mailContentBuilder;
	@Value("${spring.mail.username}")
	private String from;
	@Value("${iyzico-challenge.ticket.mail.notification.enabled:false}")
	private boolean mailNotificationEnabled;

	public void prepareAndSend(Ticket ticket) {
		this.logger.info("TicketMailService - prepareAndSend() method is called.");
		try {
			MimeMessagePreparator messagePreparator = mimeMessage -> {
				String content = this.mailContentBuilder.build(ticket);
				MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
				messageHelper.setFrom(this.from);
				messageHelper.setTo(ticket.getEmail());
				messageHelper.setSubject("Event registering informatin");
				messageHelper.setText(content, true);
				messageHelper.setSentDate(new Date());
			};
			this.mailSender.send(messagePreparator);
		} catch (MailException e) {
			throw e;
		}
	}

	// for testing purpose
	public void setPort(int port) {
		this.mailSender.setPort(port);
	}

	public void setHost(String host) {
		this.mailSender.setHost(host);
	}

	public boolean isMailNotificationEnabled() {
		return this.mailNotificationEnabled;
	}
}
