package com.practicesoftwaretesting.pages.product;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.practicesoftwaretesting.pages.BasePage;
import com.practicesoftwaretesting.pages.checkout.CartPage;
import com.practicesoftwaretesting.pages.common.NavigationBar;

import lombok.Getter;


@Getter
public class ProductDetailsPage extends BasePage
{
	@FindBy(xpath = "//span[@data-test='unit-price']")
	private WebElement textUnitPrice;
	@FindBy(xpath = "//p[@data-test='product-description']")
	private WebElement textProductDescription;
	@FindBy(xpath = "//button[@data-test='decrease-quantity']")
	private WebElement buttonDecreaseQuantity;
	@FindBy(xpath = "//input[@data-test='quantity']")
	private WebElement inputProductQuantity;
	@FindBy(xpath = "//button[@data-test='increase-quantity']")
	private WebElement buttonIncreaseQuantity;
	@FindBy(xpath = "//button[@data-test='add-to-cart']")
	private WebElement buttonAddToCart;
	@FindBy(xpath = "//button[@data-test='add-to-favorites']")
	private WebElement buttonAddToFavorites;
	@FindBy(xpath = "//div[@class='input-group quantity']/descendant::button")
	private WebElement buttonsQuantityGroup;
	@FindBy(xpath = "//h1[text()='Related products']/parent::div/descendant::h5[@class='card-title']")
	private List<WebElement> cardsRelatedProducts;

	public ProductDetailsPage(WebDriver driver, WebDriverWait wait)
	{
		super(driver, wait);
		PageFactory.initElements(driver, this);
	}

	public ProductDetailsPage increaseProductQuantityByClicking(int quantity)
	{
		waitForElement(buttonsQuantityGroup);
		for (int i = 0; i < quantity; i++)
		{
			buttonIncreaseQuantity.click();
		}
		return this;
	}

	public ProductDetailsPage addProductToCart()
	{
		buttonAddToCart.click();
		waitForElement(new NavigationBar(getDriver(), getWait()).getCartQuantity());
		return this;
	}

	public CartPage navigateToCheckout()
	{
		new NavigationBar(getDriver(), getWait()).getButtonCart().click();
		return new CartPage(getDriver(), getWait());
	}
}
