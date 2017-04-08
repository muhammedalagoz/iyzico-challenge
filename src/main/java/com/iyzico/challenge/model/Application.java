package com.iyzico.challenge.model;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Application {

	@Value("${iyzico.application.name}")
	private String applicationName;
	@Value("${iyzico.application.version}")
	private String applicationVersion;
	@Value("${iyzico.application.createdBy}")
	private String createdBy;
	@Value("${iyzico.application.reviewers}")
	private String[] reviewers;

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	public String getApplicationVersion() {
		return applicationVersion;
	}

	public void setApplicationVersion(String applicationVersion) {
		this.applicationVersion = applicationVersion;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String[] getReviewers() {
		return reviewers;
	}

	public void setReviewers(String[] reviewers) {
		this.reviewers = reviewers;
	}

	@Override
	public String toString() {
		return "Application [applicationName=" + applicationName + ", applicationVersion=" + applicationVersion + ", createdBy=" + createdBy + ", reviewers="
				+ Arrays.toString(reviewers) + "]";
	}

}
