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
		this.firstName = "Lukasz";
		this.lastName = "Pruszynski";
		this.dateOfBirth = "12312000";
		this.address = "Sienkiewicza 82";
		this.postCode = "15-777";
		this.city = "Bialystok";
		this.state = "Podlasie";
		this.country = "Poland";
		this.phone = "333444555";
		this.email = "ltest4166+" + Math.random() + "@gmail.com";
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
