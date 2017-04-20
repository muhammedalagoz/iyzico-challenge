package com.iyzico.challenge.repository.test;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Optional;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.iyzico.challenge.entity.TicketPrice;
import com.iyzico.challenge.service.TicketPriceService;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TicketDiscountRepositoryTest {

	@Autowired
	TicketPriceService ticketPriceService;

	@Test
	public void getTicketPriceByDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, 2017);
		calendar.set(Calendar.MONTH, Calendar.DECEMBER);
		calendar.set(Calendar.DAY_OF_MONTH, 2);

		Optional<TicketPrice> price = ticketPriceService.findByFromLessThanEqualAndToGreaterThanEqual(calendar.getTime(), calendar.getTime());
		price.ifPresent(p -> {
			assertEquals(BigDecimal.valueOf(250.00).intValue(), price.get().getPrice().intValue());
		});
	}
}
