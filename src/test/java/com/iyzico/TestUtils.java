package com.iyzico;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.iyzico.challenge.register.utils.IyzicoQueryOptions;
import com.iyzico.challenge.ticket.utils.TicketUtils;

public abstract class TestUtils {

	protected Logger logger = Logger.getLogger(TestUtils.class);

	@Autowired
	protected IyzicoQueryOptions iyzicoQueryOptions;
	@Autowired
	protected TicketUtils ticketUtils;
}
