package com.iyzico.challenge.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ServerProperties {

	@Value("${iyzico-challenge.security.enabled:false}")
	private boolean securityEnabled;

	@Value("${iyzico-challenge.security.userName:iyzico}")
	private String serverUserName;

	@Value("${iyzico-challenge.security.password:challenge}")
	private String serverPassword;

	@Value("${iyzico-challenge.security.role:USER}")
	private String serverRole;

	public boolean isSecurityEnabled() {
		return securityEnabled;
	}

	public void setSecurityEnabled(boolean securityEnabled) {
		this.securityEnabled = securityEnabled;
	}

	public String getServerUserName() {
		return serverUserName;
	}

	public void setServerUserName(String serverUserName) {
		this.serverUserName = serverUserName;
	}

	public String getServerPassword() {
		return serverPassword;
	}

	public void setServerPassword(String serverPassword) {
		this.serverPassword = serverPassword;
	}

	public String getServerRole() {
		return serverRole;
	}

	public void setServerRole(String serverRole) {
		this.serverRole = serverRole;
	}
}