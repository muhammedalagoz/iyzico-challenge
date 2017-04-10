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
public class RegisterTest {

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
		assertEquals(this.registerUtil.getTestCount().intValue(), this.registerUtil.getRegisters().size());
	}

	@Test
	public void transactionOfRegisterTest() {

		this.registerUtil
				.getRegisters()
				.stream()
				.forEach(register -> {
					StringBuilder output = new StringBuilder();
					output.append(register.getTransactionCode()).append(",");

					BinNumber binNumber = this.iyzicoService.binNumberQuery(register.getCardNumber().substring(0, 6));

					if (binNumber.getStatus().equalsIgnoreCase(Status.SUCCESS.getValue())) {
						// eğer success ise price bulalım.

						List<String> cardTypes = new ArrayList<String>();
						if (StringUtils.equalsIgnoreCase(binNumber.getCardType(), "CREDIT_CARD")) {
							cardTypes.addAll(this.ticketService.getAllowedCreditCards());
						} else if (StringUtils.equalsIgnoreCase(binNumber.getCardType(), "DEBIT_CARD")) {
							cardTypes.addAll(this.ticketService.getAllowedDebitCards());
						}

						if (cardTypes.contains(binNumber.getBankName())) {
							output.append(Status.SUCCESS.getValue()).append(",");
							// bankaya izin veriliyor ise ödenecek tutarı bulalım.

							Optional<TicketPrice> price = this.ticketPriceService.findByStartDateLessThanEqualAndEndDateGreaterThanEqual(
									register.getTransacitonDate(), register.getTransacitonDate());

							if (price.isPresent()) {
								// if discount code exist, find discount rate
								Optional<TicketDiscount> discount = this.ticketDiscountService.findByDiscountCode(register.getDiscountCode());

								if (discount.isPresent()) {
									BigDecimal finalPrice = this.priceUtil.processDiscountCodeAndReturnPrice(price.get(), discount.get());
									output.append(finalPrice);
								} else {
									output.append(price.get().getTicketPrice());
								}
							}

						} else {
							output.append(Status.FAILURE.getValue()).append(",");
						}

					} else {
						output.append(binNumber.getStatus()).append(",");
					}

					assertEquals(register.getExpected(), output.toString());
				});

	}
}