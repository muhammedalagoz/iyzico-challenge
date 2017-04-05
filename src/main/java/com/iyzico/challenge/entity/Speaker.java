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

	public Speaker(Long id, String firstName, String lastName, String image, String subject, String subjectDetails) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.image = image;
		this.subject = subject;
		this.subjectDetails = subjectDetails;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getSubject() {
		return subject;
	}

	public String getSubjectDetails() {
		return subjectDetails;
	}

	public void setSubjectDetails(String subjectDetails) {
		this.subjectDetails = subjectDetails;
	}

	@Override
	public String toString() {
		StringBuilder speakerAsString = new StringBuilder();
		speakerAsString.append("Speaker [ id=").append(id).append(",");
		speakerAsString.append(" firstName=").append(firstName).append(",");
		speakerAsString.append(" lastName=").append(lastName).append(",");
		speakerAsString.append(" image=").append(image);
		speakerAsString.append(" subject=").append(subject);
		speakerAsString.append(" subjectDetails=").append(subjectDetails).append(" ]");

		return speakerAsString.toString();
	}
}
