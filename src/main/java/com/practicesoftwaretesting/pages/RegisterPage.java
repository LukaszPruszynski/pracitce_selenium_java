package com.practicesoftwaretesting.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.practicesoftwaretesting.config.Customer;

import lombok.Getter;


@Getter
public class RegisterPage extends BasePage
{
	@FindBy(xpath = "//input[@data-test='first-name']")
	private WebElement inputFirstName;
	@FindBy(xpath = "//input[@data-test='last-name']")
	private WebElement inputLastName;
	@FindBy(xpath = "//input[@data-test='dob']")
	private WebElement inputDateOfBirth;
	@FindBy(xpath = "//input[@data-test='address']")
	private WebElement inputAddress;
	@FindBy(xpath = "//input[@data-test='postcode']")
	private WebElement inputPostCode;
	@FindBy(xpath = "//input[@data-test='city']")
	private WebElement inputCity;
	@FindBy(xpath = "//input[@data-test='state']")
	private WebElement inputState;
	@FindBy(xpath = "//input[@data-test='phone']")
	private WebElement inputPhone;
	@FindBy(xpath = "//input[@data-test='email']")
	private WebElement inputEmail;
	@FindBy(xpath = "//input[@data-test='password']")
	private WebElement inputPassword;
	@FindBy(xpath = "//button[@data-test='register-submit']")
	private WebElement buttonRegister;
	@FindBy(xpath = "//form[@data-test='register-form']")
	private WebElement registerForm;

	private String selectCountry = "//option[text()='%s']";

	public RegisterPage(WebDriver driver, WebDriverWait wait)
	{
		super(driver, wait);
		PageFactory.initElements(driver, this);
	}

	public SignInPage registerCustomer(final Customer customer)
	{
		inputFirstName.sendKeys(customer.getFirstName());
		inputLastName.sendKeys(customer.getLastName());
		inputDateOfBirth.sendKeys(customer.getDateOfBirth());
		inputAddress.sendKeys(customer.getAddress());
		inputPostCode.sendKeys(customer.getPostCode());
		inputCity.sendKeys(customer.getCity());
		inputState.sendKeys(customer.getState());
		getElement(selectCountry, customer.getCountry()).click();
		inputPhone.sendKeys(customer.getPhone());
		inputEmail.sendKeys(customer.getEmail());
		inputPassword.sendKeys(customer.getPassword());
		buttonRegister.click();
		waitForElementToDisappear(registerForm);
		return new SignInPage(getDriver(), getWait());
	}
}
