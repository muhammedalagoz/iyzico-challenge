package com.iyzico.challenge.service;

import java.util.List;

import com.iyzico.challenge.entity.Ticket;

/**
 * @author alican
 * @created at 04-04-2017
 * */

public interface TicketService {
	public void save(Ticket ticket);

	public List<String> getAllowedCreditCards();

	public List<String> getAllowedDebitCards();
}
