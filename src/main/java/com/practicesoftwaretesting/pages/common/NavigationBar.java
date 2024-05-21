package com.practicesoftwaretesting.pages.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.practicesoftwaretesting.pages.BasePage;

import lombok.Getter;


@Getter
public class NavigationBar extends BasePage
{
	@FindBy(className = "navbar-brand")
	private WebElement logo;
	@FindBy(xpath = "//a[@data-test='nav-home']")
	private WebElement buttonHome;
	@FindBy(xpath = "//a[@data-test='nav-categories']")
	private WebElement buttonCategories;
	@FindBy(xpath = "//a[@data-test='nav-contact']")
	private WebElement buttonContact;
	@FindBy(xpath = "//a[@data-test='nav-sign-in']")
	private WebElement buttonSignIn;
	@FindBy(xpath = "//a[@data-test='nav-cart']")
	private WebElement buttonCart;
	@FindBy(className = "navbar-toggler")
	private WebElement navBarToggle;
	@FindBy(xpath = "//span[@data-test='cart-quantity']")
	private WebElement cartQuantity;

	public NavigationBar(WebDriver driver, WebDriverWait wait)
	{
		super(driver, wait);
		PageFactory.initElements(driver, this);
	}
}
