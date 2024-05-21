package com.practicesoftwaretesting.config;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class GiftCard
{
	private String giftCardNumber;
	private String giftCardValidationCode;

	public GiftCard()
	{
		this.giftCardNumber = "1234567890";
		this.giftCardValidationCode = "123456";
	}

	public GiftCard(String giftCardNumber, String giftCardValidationCode)
	{
		this.giftCardNumber = giftCardNumber;
		this.giftCardValidationCode = giftCardValidationCode;
	}
}
