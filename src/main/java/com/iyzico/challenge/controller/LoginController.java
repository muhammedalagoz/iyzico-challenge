package com.iyzico.challenge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	private final String LOGIN = "login";

	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public String login() {
		return this.LOGIN;
	}
}
