package com.iyzico.challenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.iyzico.challenge.payment.utils.IyzicoQueryOptions;
import com.iyzico.challenge.ticket.utils.TicketUtils;
import com.iyzipay.model.BinNumber;
import com.iyzipay.model.Locale;
import com.iyzipay.request.RetrieveBinNumberRequest;

@RestController
@RequestMapping("/api/iyzico")
public class IyzicoServiceController {

	@Autowired
	IyzicoQueryOptions iyzicoQueryOptions;
	@Autowired
	TicketUtils ticketUtils;

	@RequestMapping("/binQuery/{cardNumber}")
	@ResponseBody
	public BinNumber binNumberQuery(@PathVariable(required = true) String cardNumber) {
		RetrieveBinNumberRequest request = new RetrieveBinNumberRequest();
		request.setLocale(Locale.TR.getValue());
		request.setConversationId(ticketUtils.createConversationID());
		request.setBinNumber(cardNumber);

		BinNumber binNumber = BinNumber.retrieve(request, iyzicoQueryOptions.getQueryOptions());
		return binNumber;
	}
}
