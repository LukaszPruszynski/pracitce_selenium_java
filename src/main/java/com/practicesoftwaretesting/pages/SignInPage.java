package com.practicesoftwaretesting.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.practicesoftwaretesting.pages.account.MyAccountPage;
import com.practicesoftwaretesting.pages.checkout.CheckoutPage;

import lombok.Getter;


@Getter
public class SignInPage extends BasePage
{
	@FindBy(id = "email")
	private WebElement inputEmailAddress;
	@FindBy(id = "password")
	private WebElement inputPassword;
	@FindBy(xpath = "//input[@data-test='login-submit']")
	private WebElement buttonLogin;
	@FindBy(xpath = "//a[@data-test='register-link']")
	private WebElement linkRegister;
	@FindBy(xpath = "//a[@data-test='forgot-password-link']")
	private WebElement linkForgotPassword;
	@FindBy(xpath = "//div[@class='help-block']")
	private WebElement loginError;
	@FindBy(xpath = "//h3[text()='Login']")
	private WebElement pageTitle;
	@FindBy(xpath = "//form")
	private WebElement loginForm;

	public SignInPage(WebDriver driver, WebDriverWait wait)
	{
		super(driver, wait);
		PageFactory.initElements(driver, this);
	}

	public MyAccountPage login(final String email, final String password)
	{
		waitForElement(pageTitle);
		inputEmailAddress.sendKeys(email);
		inputPassword.sendKeys(password);
		buttonLogin.click();
		try
		{
			waitForElementToDisappear(loginForm);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return new MyAccountPage(getDriver(), getWait());
	}

	public CheckoutPage checkoutLogin(final String email, final String password)
	{
		waitForElement(loginForm);
		inputEmailAddress.sendKeys(email);
		inputPassword.sendKeys(password);
		buttonLogin.click();
		waitForElementToDisappear(loginForm);
		return new CheckoutPage(getDriver(), getWait());
	}

	public RegisterPage navigateToCustomerRegistrationPage()
	{
		waitForElement(pageTitle);
		linkRegister.click();
		return new RegisterPage(getDriver(), getWait());
	}
}
