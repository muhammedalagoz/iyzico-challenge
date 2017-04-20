package com.iyzico.challenge.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.iyzico.challenge.entity.TicketPrice;

/**
 * @author alican
 * @created at 04-04-2017
 * */

public interface TicketPriceService {
	List<TicketPrice> findAll();

	Optional<TicketPrice> findByType(String type);

	Optional<TicketPrice> findByFromLessThanEqualAndToGreaterThanEqual(Date from, Date to);
}
