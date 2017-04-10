package com.iyzico.challenge.price.utils;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.iyzico.challenge.entity.TicketDiscount;
import com.iyzico.challenge.entity.TicketPrice;

@Component
public class PriceUtils {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public BigDecimal processDiscountCodeAndReturnPrice(TicketPrice ticketPrice, TicketDiscount ticketDiscount) {
		double finalPrice = ticketPrice.getTicketPrice().doubleValue() - ticketPrice.getTicketPrice().doubleValue() * ticketDiscount.getDiscountRate() / 100;
		return BigDecimal.valueOf(finalPrice);
	}
}
