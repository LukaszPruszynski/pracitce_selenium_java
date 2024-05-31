package com.practicesoftwaretesting;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.practicesoftwaretesting.config.CreditCard;
import com.practicesoftwaretesting.config.Customer;
import com.practicesoftwaretesting.config.enums.PaymentMethod;
import com.practicesoftwaretesting.pages.HomePage;

import io.github.bonigarcia.wdm.WebDriverManager;


@Test()
public class PageObjectTests
{

	WebDriver driver;
	WebDriverWait wait;
	private final String HOME_PAGE_URL = "https://practicesoftwaretesting.com/#/";
	private final String CUSTOMER_EMAIL_ADDRESS = "customer2@practicesoftwaretesting.com";
	private final String CUSTOMER_PASSWORD = "welcome01";

	@BeforeMethod
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

	@Test
	public void loginWithIncorrectCredentials()
	{

		Assert.assertTrue(
				new HomePage(driver, wait).open()
						.navigateToSignInPage()
						.login("invalid@email.address", "noPassword")
						.getLoginError()
						.isDisplayed());
	}

	@Test
	public void loginWithCorrectCredentials()
	{
		Assert.assertTrue(
				new HomePage(driver, wait).open()
						.navigateToSignInPage()
						.login(CUSTOMER_EMAIL_ADDRESS, CUSTOMER_PASSWORD)
						.getPageTitle()
						.isDisplayed());
	}

	@Test
	public void registerNewAccount()
	{
		Assert.assertEquals(
				new HomePage(driver, wait).open()
						.navigateToSignInPage()
						.navigateToCustomerRegistrationPage()
						.registerCustomer(new Customer())
						.getPageTitle()
						.getText(), "Login");
	}

	@Test
	public void buyProduct()
	{
		Assert.assertEquals(
				new HomePage(driver, wait).open()
						.getProduct("Bolt Cutters")
						.increaseProductQuantityByClicking(2)
						.addProductToCart().navigateToCheckout()
						.proceedToSignIn()
						.checkoutLogin(CUSTOMER_EMAIL_ADDRESS, CUSTOMER_PASSWORD)
						.proceedToBillingAddress()
						.provideCustomerAddress(new Customer())
						.proceedToPayment()
						.selectPaymentMethod(PaymentMethod.CREDIT_CARD)
						.providePaymentDetails(new CreditCard())
						.confirmPayment()
						.getFeedbackBar()
						.getText(), "Payment was successful");
	}
}