package com.iyzico.challenge.repository.test;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.iyzico.challenge.entity.TicketPrice;
import com.iyzico.challenge.repository.TicketPriceRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PriceRepositoryTest {
	private static final double DELTA = 1e-15;
	@Autowired
	TicketPriceRepository ticketPriceRepository;

	@Test
	public void priceCountTest() {
		assertEquals(4, ticketPriceRepository.findAll().size());
	}

	@Test
	public void ticketPriceTest() {
		Optional<TicketPrice> price = ticketPriceRepository.findByType("Regular");

		if (price.isPresent()) {
			assertEquals(BigDecimal.valueOf(750.0).doubleValue(), price.get().getPrice().doubleValue(), DELTA);
		}
	}
}
