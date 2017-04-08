package com.iyzico.challenge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.iyzico.challenge.entity.Speaker;
import com.iyzico.challenge.entity.Ticket;
import com.iyzico.challenge.entity.TicketDiscount;
import com.iyzico.challenge.entity.TicketPrice;
import com.iyzico.challenge.service.SpeakerService;
import com.iyzico.challenge.service.TicketDiscountService;
import com.iyzico.challenge.service.TicketPriceService;
import com.iyzico.challenge.service.TicketService;

@RestController
@RequestMapping("/api/ticket")
public class TicketController {

	@Autowired
	SpeakerService speakService;
	@Autowired
	TicketService ticketService;
	@Autowired
	TicketPriceService ticketPriceService;
	@Autowired
	TicketDiscountService ticketDiscountService;

	@ResponseBody
	@RequestMapping("/speakers")
	public List<Speaker> getSpeakers() {
		return speakService.findAll();
	}

	@ResponseBody
	@RequestMapping("/prices")
	public List<TicketPrice> getTicketPrices() {
		return ticketPriceService.findAll();
	}

	@ResponseBody
	@RequestMapping("/discounts")
	public List<TicketDiscount> getTicketDiscount() {
		return ticketDiscountService.findAll();
	}

	@ResponseBody
	@RequestMapping("/allowed/creditCards")
	public List<String> getAllowedCreditCards() {
		return ticketService.getAllowedCreditCards();
	}

	@ResponseBody
	@RequestMapping("/allowed/debitCards")
	public List<String> getAllowedDebitCards() {
		return ticketService.getAllowedDebitCards();
	}

	@ResponseBody
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<Boolean> ticketRegister(@RequestBody Ticket ticket) {
		try {
			ticketService.save(ticket);
		} catch (Exception e) {
			System.err.println(e);
			return new ResponseEntity<Boolean>(false, HttpStatus.OK);
		}
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
}
