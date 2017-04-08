package com.iyzico.challenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.iyzico.challenge.service.IyzicoService;
import com.iyzipay.model.BinNumber;

@RestController
@RequestMapping("/api/iyzico")
public class IyzicoServiceController {

	@Autowired
	IyzicoService iyzicoService;

	@RequestMapping("/binQuery/{cardNumber}")
	@ResponseBody
	public BinNumber binNumberQuery(@PathVariable(required = true) String cardNumber) {
		return iyzicoService.binNumberQuery(cardNumber);
	}
}
