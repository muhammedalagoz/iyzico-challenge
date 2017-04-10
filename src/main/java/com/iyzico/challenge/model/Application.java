package com.iyzico.challenge.model;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Application {

	@Value("${iyzico.application.name}")
	private String applicationName;
	@Value("${iyzico.application.description}")
	private String applicationDescription;
	@Value("${iyzico.application.version}")
	private String applicationVersion;
	@Value("${iyzico.application.createdBy}")
	private String createdBy;
	@Value("${iyzico.application.reviewers}")
	private String[] reviewers;

	public String getApplicationName() {
		return this.applicationName;
	}

	public String getApplicationVersion() {
		return this.applicationVersion;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public String[] getReviewers() {
		return this.reviewers;
	}

	public String getApplicationDescription() {
		return this.applicationDescription;
	}

	@Override
	public String toString() {
		return "Application [applicationName=" + this.applicationName + ", applicationDescription=" + this.applicationDescription + ", applicationVersion="
				+ this.applicationVersion + ", createdBy=" + this.createdBy + ", reviewers=" + Arrays.toString(this.reviewers) + "]";
	}

}
