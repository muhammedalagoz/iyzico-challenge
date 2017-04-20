package com.iyzico.challenge.iyzico.integration;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.iyzico.TestUtils;
import com.iyzico.challenge.entity.TicketDiscount;
import com.iyzico.challenge.entity.TicketPrice;
import com.iyzico.challenge.price.utils.PriceUtils;
import com.iyzico.challenge.service.IyzicoService;
import com.iyzico.challenge.service.TicketDiscountService;
import com.iyzico.challenge.service.TicketPriceService;
import com.iyzico.challenge.service.TicketService;
import com.iyzipay.model.BinNumber;
import com.iyzipay.model.Status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RegisterTest extends TestUtils {

	@Autowired
	RegisterTestUtil registerUtil;
	@Autowired
	PriceUtils priceUtil;
	@Autowired
	IyzicoService iyzicoService;
	@Autowired
	TicketService ticketService;
	@Autowired
	TicketPriceService ticketPriceService;
	@Autowired
	TicketDiscountService ticketDiscountService;

	@Test
	public void checkRegisterInputCount() {
		assertEquals(registerUtil.getTestCount().intValue(), registerUtil.getRegisters().size());
	}

	@Test
	public void transactionOfRegisterTest() {

		StringBuffer finalOutput = new StringBuffer();
		registerUtil
		.getRegisters()
		.stream()
		.forEach(register -> {
			StringBuilder output = new StringBuilder();
			output.append(register.getTransactionCode()).append(",");

			BinNumber binNumber = iyzicoService.binNumberQuery(register.getCardNumber().substring(0, 6));

			if (binNumber.getStatus().equalsIgnoreCase(Status.SUCCESS.getValue())) {
				// eğer success ise price bulalım.

				List<String> cardTypes = new ArrayList<String>();
				if (StringUtils.equalsIgnoreCase(binNumber.getCardType(), "CREDIT_CARD")) {
					cardTypes.addAll(ticketService.getAllowedCreditCards());
				} else if (StringUtils.equalsIgnoreCase(binNumber.getCardType(), "DEBIT_CARD")) {
					cardTypes.addAll(ticketService.getAllowedDebitCards());
				}

				if (cardTypes.contains(binNumber.getBankName())) {
					output.append(Status.SUCCESS.getValue()).append(",");
					// bankaya izin veriliyor ise ödenecek tutarı bulalım.

					Optional<TicketPrice> price = ticketPriceService.findByFromLessThanEqualAndToGreaterThanEqual(register.getTransacitonDate(),
							register.getTransacitonDate());

					if (price.isPresent()) {
						// if discount code exist, find discount rate
						Optional<TicketDiscount> discount = ticketDiscountService.findByCode(register.getDiscountCode());

						if (discount.isPresent()) {
							BigDecimal finalPrice = priceUtil.processDiscountCodeAndReturnPrice(price.get(), discount.get());
							output.append(finalPrice);
						} else {
							output.append(price.get().getPrice());
						}
					}

				} else {
					output.append(Status.FAILURE.getValue()).append(",");
				}

			} else {
				output.append(binNumber.getStatus()).append(",");
			}

			finalOutput.append(output).append("\n");
			logger.info(register.getTransactionCode() + "," + register.getCardNumber());
			assertEquals(register.getExpected(), output.toString());
		});

		logger.info("Final output;\n" + finalOutput.toString());

	}
}
