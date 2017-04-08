package com.iyzico.challenge.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author alican
 * @created at 04-04-2017
 * */

@Entity(name = "tickets")
public class Ticket implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@NotEmpty
	private String nameOnTheCard;
	private String email;
	@Transient
	private boolean isValidDiscountCode;
	@Column(name = "ticketPrice")
	private BigDecimal selectedTicketType;
	private BigDecimal totalPrice;
	private BigDecimal discountAmount;
	private String discountCode;
	private String discountCodeMessage;

	@Transient
	private boolean binQueryHasError;
	private Date ticketDate;

	@PrePersist
	protected void onCreate() {
		ticketDate = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameOnTheCard() {
		return nameOnTheCard;
	}

	public void setNameOnTheCard(String nameOnTheCard) {
		this.nameOnTheCard = nameOnTheCard;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isValidDiscountCode() {
		return isValidDiscountCode;
	}

	public void setValidDiscountCode(boolean isValidDiscountCode) {
		this.isValidDiscountCode = isValidDiscountCode;
	}

	public BigDecimal getSelectedTicketType() {
		return selectedTicketType;
	}

	public void setSelectedTicketType(BigDecimal selectedTicketType) {
		this.selectedTicketType = selectedTicketType;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public BigDecimal getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(BigDecimal discountAmount) {
		this.discountAmount = discountAmount;
	}

	public String getDiscountCode() {
		return discountCode;
	}

	public void setDiscountCode(String discountCode) {
		this.discountCode = discountCode;
	}

	public String getDiscountCodeMessage() {
		return discountCodeMessage;
	}

	public void setDiscountCodeMessage(String discountCodeMessage) {
		this.discountCodeMessage = discountCodeMessage;
	}

	public boolean isBinQueryHasError() {
		return binQueryHasError;
	}

	public void setBinQueryHasError(boolean binQueryHasError) {
		this.binQueryHasError = binQueryHasError;
	}

	public Date getTicketDate() {
		return ticketDate;
	}

	public void setTicketDate(Date ticketDate) {
		this.ticketDate = ticketDate;
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", nameOnTheCard=" + nameOnTheCard + ", email=" + email + ", isValidDiscountCode=" + isValidDiscountCode
				+ ", selectedTicketType=" + selectedTicketType + ", totalPrice=" + totalPrice + ", discountAmount=" + discountAmount + ", discountCode="
				+ discountCode + ", discountCodeMessage=" + discountCodeMessage + ", binQueryHasError=" + binQueryHasError + ", ticketDate=" + ticketDate + "]";
	}

}
