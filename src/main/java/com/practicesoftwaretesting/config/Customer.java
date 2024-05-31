package com.practicesoftwaretesting.config;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Customer
{
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	private String address;
	private String postCode;
	private String city;
	private String state;
	private String country;
	private String phone;
	private String email;
	private String password;

	public Customer()
	{
		this.firstName = "Bob";
		this.lastName = "Sponge";
		this.dateOfBirth = "12312000";
		this.address = "124 Conch Street";
		this.postCode = "90210";
		this.city = "Bikini Bottom";
		this.state = "American Samoa";
		this.country = "United States of America (the)";
		this.phone = "333444555";
		this.email = "random+" + Math.random() + "@email.com";
		this.password = "Th1s!s@s3cUr3";
	}

	public Customer(final String firstName, final String lastName, final String dateOfBirth, final String address,
			final String postCode, final String city, final String state, final String country, final String phone,
			final String email, final String password)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.postCode = postCode;
		this.city = city;
		this.state = state;
		this.country = country;
		this.phone = phone;
		this.email = email;
		this.password = password;
	}
}
