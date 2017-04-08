package com.iyzico.challenge.iyzico.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.iyzico.TestUtils;
import com.iyzipay.model.BinNumber;
import com.iyzipay.model.Locale;
import com.iyzipay.model.Status;
import com.iyzipay.request.RetrieveBinNumberRequest;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BinNumberTest extends TestUtils {

	private final String CREDIT_CARD_BIN_NUMBER = "552608";
	private final String DEBIT_CARD_BIN_NUMBER = "589004";
	private final String LOCALE = Locale.TR.getValue();
	private final String CREDIT_CARD_TYPE = "CREDIT_CARD";
	private final String DEBIT_CARD_TYPE = "DEBIT_CARD";
	private final Long BANK_CODE = 46L;

	@Test
	public void retrieveBinRequestForCreditCard() {
		String conversationID = ticketUtils.createConversationID();

		RetrieveBinNumberRequest request = new RetrieveBinNumberRequest();
		request.setLocale(LOCALE);
		request.setConversationId(conversationID);
		request.setBinNumber(CREDIT_CARD_BIN_NUMBER);

		BinNumber binNumber = BinNumber.retrieve(request, iyzicoQueryOptions.getQueryOptions());
		logger.info(binNumber);

		assertNull(binNumber.getErrorCode());
		assertNull(binNumber.getErrorGroup());
		assertNull(binNumber.getErrorMessage());
		assertNotNull(binNumber.getSystemTime());
		assertEquals(LOCALE, binNumber.getLocale());
		assertEquals(BANK_CODE, binNumber.getBankCode());
		assertEquals(CREDIT_CARD_TYPE, binNumber.getCardType());
		assertEquals(conversationID, binNumber.getConversationId());
		assertEquals(CREDIT_CARD_BIN_NUMBER, binNumber.getBinNumber());
		assertEquals(Status.SUCCESS.getValue(), binNumber.getStatus());
	}

	@Test
	public void retrieveBinRequestForDebitCard() {
		String conversationID = ticketUtils.createConversationID();

		RetrieveBinNumberRequest request = new RetrieveBinNumberRequest();
		request.setLocale(LOCALE);
		request.setConversationId(conversationID);
		request.setBinNumber(DEBIT_CARD_BIN_NUMBER);

		BinNumber binNumber = BinNumber.retrieve(request, iyzicoQueryOptions.getQueryOptions());
		logger.info(binNumber);

		assertNull(binNumber.getErrorCode());
		assertNull(binNumber.getErrorGroup());
		assertNull(binNumber.getErrorMessage());
		assertNotNull(binNumber.getSystemTime());
		assertEquals(LOCALE, binNumber.getLocale());
		assertEquals(BANK_CODE, binNumber.getBankCode());
		assertEquals(DEBIT_CARD_TYPE, binNumber.getCardType());
		assertEquals(conversationID, binNumber.getConversationId());
		assertEquals(DEBIT_CARD_BIN_NUMBER, binNumber.getBinNumber());
		assertEquals(Status.SUCCESS.getValue(), binNumber.getStatus());
	}

	@Test
	public void retrieveBinRequestForInvalidBinNumber() {
		String conversationID = ticketUtils.createConversationID();

		RetrieveBinNumberRequest request = new RetrieveBinNumberRequest();
		request.setLocale(LOCALE);
		request.setConversationId(conversationID);
		request.setBinNumber("xyzabc");

		BinNumber binNumber = BinNumber.retrieve(request, iyzicoQueryOptions.getQueryOptions());
		logger.info(binNumber);

		assertNotNull(binNumber.getErrorCode());
		assertNotNull(binNumber.getErrorMessage());
		assertEquals("5066", binNumber.getErrorCode());
		assertEquals("Bin bulunamadı", binNumber.getErrorMessage());
		assertNotNull(binNumber.getSystemTime());
		assertEquals(LOCALE, binNumber.getLocale());
		assertEquals(conversationID, binNumber.getConversationId());
		assertEquals(Status.FAILURE.getValue(), binNumber.getStatus());
	}

}
