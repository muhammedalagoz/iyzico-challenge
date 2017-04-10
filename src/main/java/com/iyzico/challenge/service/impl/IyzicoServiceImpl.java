package com.iyzico.challenge.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iyzico.challenge.register.utils.IyzicoQueryOptions;
import com.iyzico.challenge.service.IyzicoService;
import com.iyzico.challenge.ticket.utils.TicketUtils;
import com.iyzipay.model.BinNumber;
import com.iyzipay.model.Locale;
import com.iyzipay.request.RetrieveBinNumberRequest;

@Service
public class IyzicoServiceImpl implements IyzicoService {
	@Autowired
	IyzicoQueryOptions iyzicoQueryOptions;
	@Autowired
	TicketUtils ticketUtils;

	@Override
	public BinNumber binNumberQuery(String cardNumber) {
		RetrieveBinNumberRequest request = new RetrieveBinNumberRequest();
		request.setLocale(Locale.TR.getValue());
		request.setConversationId(this.ticketUtils.createConversationID());
		request.setBinNumber(cardNumber);

		return BinNumber.retrieve(request, this.iyzicoQueryOptions.getQueryOptions());
	}

}
