package com.iyzico.challenge.utils.test;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.iyzico.challenge.entity.TicketDiscount;
import com.iyzico.challenge.entity.TicketPrice;
import com.iyzico.challenge.price.utils.PriceUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PriceUtilsTest {
	private static final double DELTA = 1e-15;

	@Autowired
	PriceUtils priceUtils;

	@Test
	public void processDiscountCodeToPrice() {

		TicketPrice ticketPrice = new TicketPrice();
		ticketPrice.setTicketPrice(BigDecimal.valueOf(250.0));

		TicketDiscount ticketDiscount = new TicketDiscount();
		ticketDiscount.setDiscountRate(10f);

		BigDecimal finalPrice = this.priceUtils.processDiscountCodeAndReturnPrice(ticketPrice, ticketDiscount);
		assertEquals(BigDecimal.valueOf(225.0).doubleValue(), finalPrice.doubleValue(), DELTA);
	}

}
