package com.iyzico.challenge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.iyzico.challenge.bean.TicketPrice;
import com.iyzico.challenge.utils.PriceUtils;

@RestController
@RequestMapping("/api")
public class PriceController {

	@Autowired
	PriceUtils priceUtils;

	@RequestMapping("/prices")
	@ResponseBody
	public List<TicketPrice> getTicketPrices() {
		return priceUtils.getTicketPrices();
	}
}
