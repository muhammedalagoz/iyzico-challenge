package com.iyzico.challenge.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

@Entity
public class TicketDiscount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String importance;
	private String code;
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	@Column(name = "fromDate")
	private Date from;
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	@Column(name = "toDate")
	private Date to;
	private Float rate;

	public TicketDiscount() {
		super();
	}

	public TicketDiscount(Long id, String importance, String code, Date from, Date to, Float rate) {
		super();
		this.id = id;
		this.importance = importance;
		this.code = code;
		this.from = from;
		this.to = to;
		this.rate = rate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImportance() {
		return importance;
	}

	public void setImportance(String importance) {
		this.importance = importance;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public Float getRate() {
		return rate;
	}

	public void setRate(Float rate) {
		this.rate = rate;
	}

	@Override
	public String toString() {
		return "TicketDiscount [id=" + id + ", importance=" + importance + ", code=" + code + ", from=" + from + ", to=" + to + ", rate=" + rate + "]";
	}

}
