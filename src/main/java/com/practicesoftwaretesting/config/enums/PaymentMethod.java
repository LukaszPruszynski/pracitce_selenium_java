package com.practicesoftwaretesting.config.enums;

public enum PaymentMethod
{
	BANK_TRANSFER("Bank Transfer"),
	CASH_ON_DELIVERY("Cash on Delivery"),
	CREDIT_CARD("Credit Card"),
	BUY_NOW_PAY_LATER("Buy Now Pay Later"),
	GIFT_CARD("Gift Card");

	public final String label;

	private PaymentMethod(String label)
	{
		this.label = label;
	}
}
