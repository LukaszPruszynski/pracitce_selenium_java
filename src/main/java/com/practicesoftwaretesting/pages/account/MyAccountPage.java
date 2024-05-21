package com.practicesoftwaretesting.pages.account;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.practicesoftwaretesting.pages.SignInPage;

import lombok.Getter;


@Getter
public class MyAccountPage extends SignInPage
{
	@FindBy(xpath = "//h1[@data-test='page-title']")
	private WebElement pageTitle;
	@FindBy(xpath = "//a[@data-test='nav-favorites']")
	private WebElement buttonFavorites;
	@FindBy(xpath = "//a[@data-test='nav-profile']")
	private WebElement buttonProfile;
	@FindBy(xpath = "//a[@data-test='nav-invoices']")
	private WebElement buttonInvoices;
	@FindBy(xpath = "//a[@data-test='nav-messages']")
	private WebElement buttonMessages;
	@FindBy(xpath = "//div[@class='btn-group-vertical']")
	private WebElement buttonsList;

	public MyAccountPage(WebDriver driver, WebDriverWait wait)
	{
		super(driver, wait);
		PageFactory.initElements(driver, this);
	}
}
