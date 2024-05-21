package com.practicesoftwaretesting.config;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CreditCard
{
	private String creditCardNumber;
	private String expirationDate;
	private String cvv;
	private String creditCardHolder;

	public CreditCard()
	{
		this.creditCardNumber = "1234-4321-5678-8765";
		this.expirationDate = "07/2030";
		this.cvv = "555";
		this.creditCardHolder = "John Howe";
	}

	public CreditCard(String creditCardNumber, String expirationDate, String cvv, String creditCardHolder)
	{
		this.creditCardNumber = creditCardNumber;
		this.expirationDate = expirationDate;
		this.cvv = cvv;
		this.creditCardHolder = creditCardHolder;
	}
}
