package com.iyzico.challenge.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iyzico.challenge.entity.TicketPrice;
import com.iyzico.challenge.repository.TicketPriceRepository;
import com.iyzico.challenge.service.TicketPriceService;

/**
 * @author alican
 * @created at 04-04-2017
 * */
@Service
public class TicketPriceServiceImpl implements TicketPriceService {

	@Autowired
	TicketPriceRepository ticketPriceRepository;

	@Override
	public List<TicketPrice> findAll() {
		return ticketPriceRepository.findAll();
	}

}