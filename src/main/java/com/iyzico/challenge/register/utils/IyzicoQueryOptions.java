package com.iyzico.challenge.register.utils;

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
		return this.apiKey;
	}

	public String getApiSecret() {
		return this.apiSecret;
	}

	public String getApiBaseUrl() {
		return this.apiBaseUrl;
	}

	public Options getQueryOptions() {

		if (this.queryOptions == null) {
			this.queryOptions = new Options();
			this.queryOptions.setApiKey(this.apiKey);
			this.queryOptions.setSecretKey(this.apiSecret);
			this.queryOptions.setBaseUrl(this.apiBaseUrl);
		}

		return this.queryOptions;
	}

}
