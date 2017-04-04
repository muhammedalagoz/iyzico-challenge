package com.iyzico.challenge.bean;

import java.math.BigDecimal;
import java.util.Date;

public class TicketPrice {

	Date startDate;
	Date endDate;
	String ticketType;
	BigDecimal ticketPrice;

	public TicketPrice(Date startDate, Date endDate, String ticketType, BigDecimal ticketPrice) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.ticketType = ticketType;
		this.ticketPrice = ticketPrice;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getTicketType() {
		return ticketType;
	}

	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}

	public BigDecimal getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(BigDecimal ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	@Override
	public String toString() {
		return "TicketPrice [startDate=" + startDate + ", endDate=" + endDate + ", ticketType=" + ticketType + ", ticketPrice=" + ticketPrice + "]";
	}

}
