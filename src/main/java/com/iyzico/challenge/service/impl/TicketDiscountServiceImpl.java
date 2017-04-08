package com.iyzico.challenge.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iyzico.challenge.entity.TicketDiscount;
import com.iyzico.challenge.repository.TicketDiscountRepository;
import com.iyzico.challenge.service.TicketDiscountService;

/**
 * @author alican
 * @created at 04-04-2017
 * */
@Service
public class TicketDiscountServiceImpl implements TicketDiscountService {

	@Autowired
	TicketDiscountRepository ticketDiscountRepository;

	@Override
	public List<TicketDiscount> findAll() {
		return ticketDiscountRepository.findAll();
	}

}
