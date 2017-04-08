package com.iyzico.challenge.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iyzico.challenge.entity.Ticket;
import com.iyzico.challenge.repository.TicketRepository;
import com.iyzico.challenge.service.TicketService;
import com.iyzico.challenge.ticket.utils.TicketUtils;

/**
 * @author alican
 * @created at 04-04-2017
 * */
@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	TicketRepository ticketRepository;
	@Autowired
	TicketUtils ticketUtils;

	@Override
	public void save(Ticket ticket) {
		ticketRepository.save(ticket);
	}

	@Override
	public List<String> getAllowedCreditCards() {
		return ticketUtils.getAllowedCreditCards();
	}

	@Override
	public List<String> getAllowedDebitCards() {
		return ticketUtils.getAllowedDebitCards();
	}
}
