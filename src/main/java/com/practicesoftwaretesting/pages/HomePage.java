package com.practicesoftwaretesting.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.practicesoftwaretesting.pages.common.NavigationBar;
import com.practicesoftwaretesting.pages.product.ProductDetailsPage;

import lombok.Getter;


@Getter
public class HomePage extends BasePage
{
	private final String HOME_PAGE_URL = "https://practicesoftwaretesting.com/#/";

	@FindBy(className = "form-select")
	private WebElement selectSort;
	@FindBy(xpath = "//input[@data-test='search-query']")
	private WebElement inputSearch;
	@FindBy(xpath = "//button[@data-test='search-reset']")
	private WebElement buttonSearchClear;
	@FindBy(xpath = "//button[@data-test='search-submit']")
	private WebElement buttonSearchSubmit;
	@FindBy(xpath = "//a[@aria-label='Previous']")
	private WebElement buttonPrevious;
	@FindBy(xpath = "//a[@aria-label='Next']")
	private WebElement buttonNext;
	@FindBy(className = "card")
	private WebElement productCard;

	private String xPathPageLink = "//li[contains(@class,'page-item']/child::a[text()='%s']";
	private String xpathCategoryCheckbox = "//label[contains(text(),'%s')]/child::input";
	private String xPathProduct = "//h5[contains(text(),'%s')]/ancestor::a";
	private String xPathProductPrice = "//h5[@data-test='%s']/ancestor::a/descendant::span[@data-test='product-price']";

	public HomePage(WebDriver driver, WebDriverWait wait)
	{
		super(driver, wait);
		PageFactory.initElements(driver, this);
	}

	public HomePage open()
	{
		getDriver().get(HOME_PAGE_URL);
		return this;
	}

	public SignInPage navigateToSignInPage()
	{
		new NavigationBar(this.getDriver(), this.getWait()).getButtonSignIn().click();
		return new SignInPage(getDriver(), getWait());
	}

	public ProductDetailsPage getProduct(String productName)
	{
		waitForElement(productCard);
		getElement(By.xpath(String.format(xPathProduct, productName))).click();
		return new ProductDetailsPage(getDriver(), getWait());
	}
}
