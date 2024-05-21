package com.practicesoftwaretesting.pages.checkout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.practicesoftwaretesting.pages.BasePage;

import lombok.Getter;


@Getter
public class CheckoutPage extends BasePage
{
	@FindBy(xpath = "//button[contains(@data-test,'finish')]")
	private WebElement buttonConfirm;
	@FindBy(xpath = "//div[@class='help-block']")
	private WebElement feedbackBar;
	@FindBy(xpath = "//div[@class='row']")
	private WebElement welcomeText;
	@FindBy(xpath = "//button[@data-test='proceed-2']")
	private WebElement proceedToBilling;
	@FindBy(xpath = "//button[@data-test='proceed-3']")
	private WebElement proceedToPayment;

	public CheckoutPage(WebDriver driver, WebDriverWait wait)
	{
		super(driver, wait);
		PageFactory.initElements(driver, this);
	}

	public BillingAddressPage proceedToBillingAddress()
	{
		proceedToBilling.click();
		return new BillingAddressPage(getDriver(), getWait());
	}

	public PaymentPage proceedToPayment()
	{
		proceedToPayment.click();
		return new PaymentPage(getDriver(), getWait());
	}

	public CheckoutPage confirmPayment()
	{
		buttonConfirm.click();
		waitForElement(feedbackBar);
		return this;
	}
}
