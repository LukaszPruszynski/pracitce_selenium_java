package com.practicesoftwaretesting.config.enums;

public enum MonthlyInstallments
{
	THREE("3"),
	SIX("6"),
	NINE("9"),
	TWELVE("12");

	public final String label;

	private MonthlyInstallments(String label)
	{
		this.label = label;
	}
}
