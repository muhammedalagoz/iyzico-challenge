package com.iyzico.challenge.iyzico.integration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.iyzico.challenge.payment.utils.IyzicoQueryOptions;
import com.iyzico.challenge.ticket.utils.TicketUtils;
import com.iyzipay.model.BinNumber;
import com.iyzipay.model.Locale;
import com.iyzipay.request.RetrieveBinNumberRequest;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BinNumberQuery {

	@Autowired
	TicketUtils ticketUtils;
	@Autowired
	IyzicoQueryOptions iyzicoQueryOptions;

	@Test
	public void createBinNumber() {

		RetrieveBinNumberRequest request = new RetrieveBinNumberRequest();
		request.setLocale(Locale.TR.getValue());
		request.setConversationId(ticketUtils.createConversationID());
		request.setBinNumber("552608");

		BinNumber binNumber = BinNumber.retrieve(request, iyzicoQueryOptions.getQueryOptions());
		System.out.println(binNumber);
	}

}
