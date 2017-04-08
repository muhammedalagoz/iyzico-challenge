package com.iyzico.challenge.mail;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.iyzico.challenge.entity.Ticket;
import com.iyzico.challenge.entity.TicketDiscount;
import com.iyzico.challenge.service.TicketDiscountService;

@Service
public class TicketMailContentBuilder {

	@Autowired
	TemplateEngine engine;
	@Autowired
	TicketDiscountService ticketDiscountService;

	public String build(Ticket ticket) {
		Context context = new Context();
		context.setVariable("message", "Congratulations! Your ticket has been registered.");
		context.setVariable("ticket", ticket);

		if (StringUtils.isNotBlank(ticket.getDiscountCode())) {
			TicketDiscount discount = ticketDiscountService.findByDiscountCode(ticket.getDiscountCode());

			context.setVariable("discount", discount);
		}

		return engine.process("mail", context);
	}
}
