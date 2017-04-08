package com.iyzico.challenge.service;

import com.iyzipay.model.BinNumber;

public interface IyzicoService {
	public abstract BinNumber binNumberQuery(String cardNumber);
}
