package com.iyzico.challenge.ticket.utils;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Component;

@Component
public class TicketUtils {

	@Value("#{'${iyzico-challenge.allowed.credit.cards}'.split(',')}")
	List<String> allowedCreditCards;

	@Value("#{'${iyzico-challenge.allowed.debit.cards}'.split(',')}")
	List<String> allowedDebitCards;

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	public void setAllowedCreditCards(List<String> allowedCreditCards) {
		this.allowedCreditCards = allowedCreditCards;
	}

	public void setAllowedDebitCards(List<String> allowedDebitCards) {
		this.allowedDebitCards = allowedDebitCards;
	}

	public List<String> getAllowedCreditCards() {
		return allowedCreditCards;
	}

	public List<String> getAllowedDebitCards() {
		return allowedDebitCards;
	}

	public synchronized String createConversationID() {
		return String.valueOf(UUID.randomUUID());
	}

}
