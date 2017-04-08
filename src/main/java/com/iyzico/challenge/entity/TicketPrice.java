package com.iyzico.challenge.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class TicketPrice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@JsonFormat(pattern = "dd.MM.yyyy")
	Date startDate;
	@JsonFormat(pattern = "dd.MM.yyyy")
	Date endDate;
	String ticketType;
	BigDecimal ticketPrice;

	public TicketPrice() {
		super();
	}

	public TicketPrice(Long id, Date startDate, Date endDate, String ticketType, BigDecimal ticketPrice) {
		super();
		this.id = id;
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
		return "TicketPrice [ id=" + id + ", startDate=" + startDate + ", endDate=" + endDate + ", ticketType=" + ticketType + ", ticketPrice=" + ticketPrice
				+ "]";
	}

}
