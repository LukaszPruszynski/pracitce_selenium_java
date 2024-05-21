package com.practicesoftwaretesting.pages.checkout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.practicesoftwaretesting.pages.BasePage;
import com.practicesoftwaretesting.pages.SignInPage;

import lombok.Getter;


@Getter
public class CartPage extends BasePage
{
	@FindBy(xpath = "//tbody")
	private WebElement tableRow;
	@FindBy(xpath = "//button[contains(@data-test,'proceed')]")
	private WebElement buttonProceed;

	private String xPathInputProductQuantity = "//span[contains(text(),'%s')]/ancestor::tr/descendant::input[@class='form-control quantity']";
	private String xPathButtonRemoveProduct = "//span[contains(text(),'%s')]/ancestor::tr/descendant::a[@class='btn btn-danger']";

	public CartPage(WebDriver driver, WebDriverWait wait)
	{
		super(driver, wait);
		PageFactory.initElements(driver, this);
	}

	public SignInPage proceedToSignIn()
	{
		waitForElement(tableRow);
		buttonProceed.click();
		return new SignInPage(getDriver(), getWait());
	}
}
