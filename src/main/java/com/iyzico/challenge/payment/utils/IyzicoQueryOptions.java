package com.iyzico.challenge.payment.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.iyzipay.Options;

@Component
public class IyzicoQueryOptions {

	@Value("${iyzico-challenge.api.key}")
	private String apiKey;
	@Value("${iyzico-challenge.api.secret}")
	private String apiSecret;
	@Value("${iyzico-challenge.api.baseUrl}")
	private String apiBaseUrl;
	private Options queryOptions;

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public String getApiSecret() {
		return apiSecret;
	}

	public void setApiSecret(String apiSecret) {
		this.apiSecret = apiSecret;
	}

	public String getApiBaseUrl() {
		return apiBaseUrl;
	}

	public void setApiBaseUrl(String apiBaseUrl) {
		this.apiBaseUrl = apiBaseUrl;
	}

	public Options getQueryOptions() {

		if (queryOptions == null) {
			queryOptions = new Options();
			queryOptions.setApiKey(apiKey);
			queryOptions.setSecretKey(apiSecret);
			queryOptions.setBaseUrl(apiBaseUrl);
		}

		return queryOptions;
	}

}
