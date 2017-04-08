package com.iyzico.challenge.entity;

import java.util.Date;

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

	private String importanceOfDay;
	private String discountCode;

	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date availableDiscountStartDate;

	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date availableDiscountEndDate;

	private Float discountRate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImportanceOfDay() {
		return importanceOfDay;
	}

	public void setImportanceOfDay(String importanceOfDay) {
		this.importanceOfDay = importanceOfDay;
	}

	public String getDiscountCode() {
		return discountCode;
	}

	public void setDiscountCode(String discountCode) {
		this.discountCode = discountCode;
	}

	public Date getAvailableDiscountStartDate() {
		return availableDiscountStartDate;
	}

	public void setAvailableDiscountStartDate(Date availableDiscountStartDate) {
		this.availableDiscountStartDate = availableDiscountStartDate;
	}

	public Date getAvailableDiscountEndDate() {
		return availableDiscountEndDate;
	}

	public void setAvailableDiscountEndDate(Date availableDiscountEndDate) {
		this.availableDiscountEndDate = availableDiscountEndDate;
	}

	public Float getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(Float discountRate) {
		this.discountRate = discountRate;
	}

	@Override
	public String toString() {
		StringBuilder ticketDiscountAsString = new StringBuilder();
		ticketDiscountAsString.append("TicketDiscount [id=").append(id);
		ticketDiscountAsString.append(", importanceOfDay=").append(importanceOfDay);
		ticketDiscountAsString.append(", discountCode=").append(discountCode);
		ticketDiscountAsString.append(", availableDiscountStartDate=").append(availableDiscountStartDate);
		ticketDiscountAsString.append(", availableDiscountEndDate=").append(availableDiscountEndDate);
		ticketDiscountAsString.append(", discountRate=").append(discountRate).append(" ]");

		return ticketDiscountAsString.toString();
	}

}
