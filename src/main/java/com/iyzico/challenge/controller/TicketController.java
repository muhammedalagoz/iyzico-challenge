package com.iyzico.challenge.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.iyzico.challenge.mail.TicketMailService;
import com.iyzico.challenge.service.SpeakerService;
import com.iyzico.challenge.service.TicketDiscountService;
import com.iyzico.challenge.service.TicketPriceService;
import com.iyzico.challenge.service.TicketService;

@Api(basePath = "/api/ticket", produces = "application/json", value = "Ticket", description = "Operations with ticket, ticketprice, ticketdiscount, speakers")
@RestController
@RequestMapping("/api/ticket")
public class TicketController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	SpeakerService speakService;
	@Autowired
	TicketService ticketService;
	@Autowired
	TicketPriceService ticketPriceService;
	@Autowired
	TicketDiscountService ticketDiscountService;
	@Autowired
	TicketMailService ticketMailService;

	@ApiOperation(value = "Get speakers", notes = "Fetch List of Speaker")
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Please check url"), @ApiResponse(code = 200, message = "List<Speakers>"),
			@ApiResponse(code = 500, message = "Error occurred while fetching Speakers") })
	@ResponseBody
	@RequestMapping("/speakers")
	public List<Speaker> getSpeakers() {
		return speakService.findAll();
	}

	@ApiOperation(value = "Get prices", notes = "Fetch List of Price")
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Please check url"), @ApiResponse(code = 200, message = "List<TicketPrice>"),
			@ApiResponse(code = 500, message = "Error occurred while fetching Prices") })
	@ResponseBody
	@RequestMapping("/prices")
	public List<TicketPrice> getTicketPrices() {
		return ticketPriceService.findAll();
	}

	@ApiOperation(value = "Get discounts", notes = "Fetch List of Discount")
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Please check url"), @ApiResponse(code = 200, message = "List<TicketDiscount>"),
			@ApiResponse(code = 500, message = "Error occurred while fetching Discounts") })
	@ResponseBody
	@RequestMapping("/discounts")
	public List<TicketDiscount> getTicketDiscount() {
		return ticketDiscountService.findAll();
	}

	@ApiOperation(value = "Get allowed credit cards for register", notes = "Fetch List of allowed credit card")
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Please check url"), @ApiResponse(code = 200, message = "List"),
			@ApiResponse(code = 500, message = "Error occurred while fetching allowed credit cards") })
	@ResponseBody
	@RequestMapping("/allowed/creditCards")
	public List<String> getAllowedCreditCards() {
		return ticketService.getAllowedCreditCards();
	}

	@ApiOperation(value = "Get allowed debit cards for register", notes = "Fetch List of allowed debit card")
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Please check url"), @ApiResponse(code = 200, message = "List"),
			@ApiResponse(code = 500, message = "Error occurred while fetching allowed debit card") })
	@ResponseBody
	@RequestMapping("/allowed/debitCards")
	public List<String> getAllowedDebitCards() {
		return ticketService.getAllowedDebitCards();
	}

	@ApiOperation(value = "Create new register", notes = "Create new request ")
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Please check url"), @ApiResponse(code = 400, message = "Fields are with validation errors"),
			@ApiResponse(code = 200, message = "List"), @ApiResponse(code = 500, message = "Error occurred while creating register") })
	@ResponseBody
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<Boolean> ticketRegister(@RequestBody @Valid Ticket ticket) {
		try {
			ticketService.save(ticket);
			ticketMailService.prepareAndSend(ticket);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return new ResponseEntity<Boolean>(false, HttpStatus.OK);
		}
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
}
