package com.iyzico.challenge.mail.test;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Date;

import javax.mail.Message;
import javax.mail.MessagingException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.ServerSetupTest;
import com.iyzico.challenge.entity.Ticket;
import com.iyzico.challenge.mail.TicketMailService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TicketMailServiceTest {

	@Autowired
	TicketMailService ticketMailService;

	private GreenMail testSmtp;

	@Before
	public void testSmtpInit() {
		testSmtp = new GreenMail(ServerSetupTest.ALL);
		testSmtp.start();

		// don't forget to set the test port!
		ticketMailService.setPort(3025);
		ticketMailService.setHost("localhost");

	}

	@Test
	public void testEmail() throws InterruptedException, MessagingException {

		Ticket ticket = new Ticket();
		ticket.setEmail("alican.akkus94@gmail.com");
		ticket.setTotalPrice(BigDecimal.valueOf(750));
		ticket.setTicketDate(new Date());

		ticketMailService.prepareAndSend(ticket);

		Message[] messages = testSmtp.getReceivedMessages();
		assertEquals(1, messages.length);
		// assertEquals("test subject", messages[0].getSubject());
		// String body = GreenMailUtil.getBody(messages[0]).replaceAll("=\r?\n", "");
		// assertEquals("test message", body);
	}

	@After
	public void cleanup() {
		testSmtp.stop();
	}
}