package com.iyzico.challenge.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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

	@Override
	public Optional<TicketPrice> findByFromLessThanEqualAndToGreaterThanEqual(Date from, Date to) {
		return ticketPriceRepository.findByFromLessThanEqualAndToGreaterThanEqual(from, to);
	}

	@Override
	public Optional<TicketPrice> findByType(String type) {
		return ticketPriceRepository.findByType(type);
	}

}
