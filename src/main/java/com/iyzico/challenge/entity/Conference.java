package com.iyzico.challenge.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author alican
 * @created at 04-04-2017
 * */

@Entity
public class Conference {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column(name = "title")
	private String conferenceTitle;
	@Column(name = "date")
	private Date conferenceDate;

	public Conference() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getConferenceTitle() {
		return conferenceTitle;
	}

	public void setConferenceTitle(String conferenceTitle) {
		this.conferenceTitle = conferenceTitle;
	}

	public Date getConferenceDate() {
		return conferenceDate;
	}

	public void setConferenceDate(Date conferenceDate) {
		this.conferenceDate = conferenceDate;
	}

	@Override
	public String toString() {
		StringBuilder conferenceAsString = new StringBuilder();
		conferenceAsString.append("Conference [id=").append(id);
		conferenceAsString.append(", conferenceTitle=").append(conferenceTitle);
		conferenceAsString.append(", conferenceDate=").append(conferenceDate).append("]");

		return conferenceAsString.toString();
	}

}
