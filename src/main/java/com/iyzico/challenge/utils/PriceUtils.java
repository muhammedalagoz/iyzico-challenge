package com.iyzico.challenge.utils;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.iyzico.challenge.bean.TicketPrice;

@Component
public class PriceUtils {

	private final String PRICE_DEFINITIONS_PREFIX = "iyzico-challenge.ticket.price";
	private Logger logger = Logger.getLogger(PriceUtils.class);
	private SimpleDateFormat priceFormatter = new SimpleDateFormat("dd-mm-yyyy");

	@Autowired
	Environment env;

	List<TicketPrice> ticketPrices = new ArrayList<>();

	@PostConstruct
	private void readTicketPrices() {
		try {
			int priceDefinitionsCount = env.getProperty("iyzico-challenge.ticket.price.count", Integer.class);

			if (priceDefinitionsCount > 0) {
				// read price definitions

				for (int i = 1; i <= priceDefinitionsCount; i++) {
					String startDate = env.getProperty(PRICE_DEFINITIONS_PREFIX + "." + i + ".startdate", String.class);
					String endDate = env.getProperty(PRICE_DEFINITIONS_PREFIX + "." + i + ".enddate", String.class);
					String type = env.getProperty(PRICE_DEFINITIONS_PREFIX + "." + i + ".type", String.class);
					BigDecimal price = env.getProperty(PRICE_DEFINITIONS_PREFIX + "." + i + ".price", BigDecimal.class);

					Date ticketStartDate = priceFormatter.parse(startDate);
					Date ticketEndDate = priceFormatter.parse(endDate);

					TicketPrice ticketPrice = new TicketPrice(ticketStartDate, ticketEndDate, type, price);
					ticketPrices.add(ticketPrice);
				}

				ticketPrices.stream().forEach(p -> {
					logger.info(p);
				});
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
