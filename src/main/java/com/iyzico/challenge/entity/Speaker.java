package com.iyzico.challenge.entity;

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
public class Speaker {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String firstName;
	private String lastName;
	private String image;
	private String subject;
	@Column(length = 500)
	private String subjectDetails;

	public Speaker() {
		super();
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getSubject() {
		return this.subject;
	}

	public String getSubjectDetails() {
		return this.subjectDetails;
	}

	public void setSubjectDetails(String subjectDetails) {
		this.subjectDetails = subjectDetails;
	}

	@Override
	public String toString() {
		StringBuilder speakerAsString = new StringBuilder();
		speakerAsString.append("Speaker [ id=").append(this.id).append(",");
		speakerAsString.append(" firstName=").append(this.firstName).append(",");
		speakerAsString.append(" lastName=").append(this.lastName).append(",");
		speakerAsString.append(" image=").append(this.image);
		speakerAsString.append(" subject=").append(this.subject);
		speakerAsString.append(" subjectDetails=").append(this.subjectDetails).append(" ]");

		return speakerAsString.toString();
	}
}
