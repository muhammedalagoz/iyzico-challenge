package com.iyzico.challenge.mail;

import java.util.Optional;

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
			Optional<TicketDiscount> discount = this.ticketDiscountService.findByDiscountCode(ticket.getDiscountCode());

			if (discount.isPresent()) {
				context.setVariable("discount", discount.get());
			}

		}

		return this.engine.process("mail", context);
	}
}
