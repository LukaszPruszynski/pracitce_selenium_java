package com.practicesoftwaretesting.config;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class BankTransfer
{
	private String bankName;
	private String accountName;
	private String accountNumber;

	public BankTransfer()
	{
		this.bankName = "Credit Suisse";
		this.accountName = "Very important and sneaky millionaire";
		this.accountNumber = "12345678901234567890123456";
	}

	public BankTransfer(String bankName, String accountName, String accountNumber)
	{
		this.bankName = bankName;
		this.accountName = accountName;
		this.accountNumber = accountNumber;
	}
}
