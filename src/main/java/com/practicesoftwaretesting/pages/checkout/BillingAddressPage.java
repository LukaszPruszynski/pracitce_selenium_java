package com.practicesoftwaretesting.pages.checkout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.practicesoftwaretesting.config.Customer;


public class BillingAddressPage extends CheckoutPage
{
	@FindBy(id = "address")
	private WebElement inputAddress;
	@FindBy(id = "city")
	private WebElement inputCity;
	@FindBy(id = "state")
	private WebElement inputState;
	@FindBy(id = "country")
	private WebElement inputCountry;
	@FindBy(id = "postcode")
	private WebElement inputPostCode;
	@FindBy(xpath = "//button[contains(@data-test,'proceed')]")
	private WebElement buttonProceedToCheckout;
	@FindBy(xpath = "//form")
	private WebElement addressForm;

	public BillingAddressPage(WebDriver driver, WebDriverWait wait)
	{
		super(driver, wait);
		PageFactory.initElements(driver, this);
	}

	public CheckoutPage provideCustomerAddress(final Customer customer)
	{
		waitForElement(addressForm);
		inputAddress.sendKeys(customer.getAddress());
		inputCity.sendKeys(customer.getCity());
		inputState.sendKeys(customer.getState());
		inputCountry.sendKeys(customer.getCountry());
		inputPostCode.sendKeys(customer.getPostCode());
		return new CheckoutPage(getDriver(), getWait());
	}
}
