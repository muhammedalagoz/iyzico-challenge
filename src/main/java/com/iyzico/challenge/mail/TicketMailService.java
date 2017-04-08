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

	public void prepareAndSend(Ticket ticket) {
		try {
			MimeMessagePreparator messagePreparator = mimeMessage -> {
				String content = mailContentBuilder.build(ticket);
				MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
				messageHelper.setFrom(from);
				messageHelper.setTo(ticket.getEmail());
				messageHelper.setSubject("Event registering informatin");
				messageHelper.setText(content, true);
				messageHelper.setSentDate(new Date());
			};
			mailSender.send(messagePreparator);
		} catch (MailException e) {
			logger.error(e, e);
			throw e;
		}
	}

	// for testing purpose
	public void setPort(int port) {
		mailSender.setPort(port);
	}

	public void setHost(String host) {
		mailSender.setHost(host);
	}

}
