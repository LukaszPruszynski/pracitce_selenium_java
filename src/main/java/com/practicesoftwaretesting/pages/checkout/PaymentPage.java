package com.practicesoftwaretesting.pages.checkout;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.practicesoftwaretesting.config.CreditCard;
import com.practicesoftwaretesting.config.enums.MonthlyInstallments;
import com.practicesoftwaretesting.config.enums.PaymentMethod;
import com.practicesoftwaretesting.pages.BasePage;


public class PaymentPage extends BasePage
{
	@FindBy(id = "bank_name")
	private WebElement inputBankName;
	@FindBy(id = "account_name")
	private WebElement inputBankAccountName;
	@FindBy(id = "account_number")
	private WebElement inputBankAccountNumber;
	@FindBy(id = "credit_card_number")
	private WebElement inputCreditCardNumber;
	@FindBy(id = "expiration_date")
	private WebElement inputCreditCardExpirationDate;
	@FindBy(id = "cvv")
	private WebElement inputCreditCardCvv;
	@FindBy(id = "card_holder_name")
	private WebElement inputCreditCardHolder;
	@FindBy(id = "gift_card_number")
	private WebElement inputGiftCardNumber;
	@FindBy(id = "validation_code")
	private WebElement inputGiftCardValidationCode;
	@FindBy(xpath = "//input")
	private List<WebElement> inputList;

	private String xPathPaymentMethodByText = "//select[@data-test='payment-method']/option[text()='%s']";
	private String xPathMonthlyInstallmentsByValue = "//select[@data-test='monthly_installments']/option[@value='%s']";

	public PaymentPage(WebDriver driver, WebDriverWait wait)
	{
		super(driver, wait);
		PageFactory.initElements(driver, this);
	}

	public PaymentPage selectPaymentMethod(final PaymentMethod paymentMethod)
	{
		getElement(By.xpath(String.format(xPathPaymentMethodByText, paymentMethod.label))).click();
		return this;
	}

	public PaymentPage selectMonthlyInstallments(final MonthlyInstallments monthlyInstallments)
	{
		getElement(By.xpath(String.format(xPathMonthlyInstallmentsByValue, monthlyInstallments.label))).click();
		return this;
	}

	public CheckoutPage providePaymentDetails(final CreditCard creditCard)
	{
		inputCreditCardNumber.sendKeys(creditCard.getCreditCardNumber());
		inputCreditCardExpirationDate.sendKeys(creditCard.getExpirationDate());
		inputCreditCardCvv.sendKeys(creditCard.getCvv());
		inputCreditCardHolder.sendKeys(creditCard.getCreditCardHolder());
		return new CheckoutPage(getDriver(), getWait());
	}
}
