package com.iyzico.challenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iyzico.challenge.bean.Application;

@Controller
public class AppController {

	@Autowired
	Application app;

	@RequestMapping(path = { "/", "/home" }, method = RequestMethod.GET)
	public String home() {
		return "home";
	}

	@RequestMapping(path = { "/app" }, method = RequestMethod.GET)
	@ResponseBody
	public Application appInfo() {
		return app;
	}
}
