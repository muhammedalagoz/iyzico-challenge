package com.iyzico.challenge.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
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
	@Column(name = "fromDate")
	Date from;
	@JsonFormat(pattern = "dd.MM.yyyy")
	@Column(name = "toDate")
	Date to;
	String type;
	BigDecimal price;

	public TicketPrice() {
		super();
	}

	public TicketPrice(Long id, Date from, Date to, String type, BigDecimal price) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.type = type;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFrom() {
		return from;
	}

	public void setFrom(Date from) {
		this.from = from;
	}

	public Date getTo() {
		return to;
	}

	public void setTo(Date to) {
		this.to = to;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "TicketPrice [id=" + id + ", from=" + from + ", to=" + to + ", type=" + type + ", price=" + price + "]";
	}

}
