package com.iyzico.challenge.service;

import java.util.List;
import java.util.Optional;

import com.iyzico.challenge.entity.TicketDiscount;

/**
 * @author alican
 * @created at 04-04-2017
 * */

public interface TicketDiscountService {
	List<TicketDiscount> findAll();

	Optional<TicketDiscount> findByDiscountCode(String code);
}
