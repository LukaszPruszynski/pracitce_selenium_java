package com.practicesoftwaretesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


@Test()
public class ImplicitWaitTests
{
	public WebDriver driver;
	private final String HOME_PAGE_URL = "https://practicesoftwaretesting.com/#/";
	private final String CUSTOMER_EMAIL_ADDRESS = "customer2@practicesoftwaretesting.com";
	private final String CUSTOMER_PASSWORD = "welcome01";

	@BeforeMethod
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}

	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

	@Test
	public void loginWithInCorrectCredentialsTheHardWay()
	{
		driver.get(HOME_PAGE_URL);
		driver.findElement(By.xpath("//a[@data-test='nav-sign-in']")).click();
		driver.findElement(By.id("email")).sendKeys("invalid@email.com");
		driver.findElement(By.id("password")).sendKeys("S@mplePassword1");
		driver.findElement(By.xpath("//input[@data-test='login-submit']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='help-block']")).isDisplayed());
	}

	@Test
	public void loginWithCorrectCredentialsTheHardWay()
	{
		driver.get(HOME_PAGE_URL);
		driver.findElement(By.xpath("//a[@data-test='nav-sign-in']")).click();
		driver.findElement(By.id("email")).sendKeys(CUSTOMER_EMAIL_ADDRESS);
		driver.findElement(By.id("password")).sendKeys(CUSTOMER_PASSWORD);
		driver.findElement(By.xpath("//input[@data-test='login-submit']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//h1[@data-test='page-title']")).isDisplayed());
	}

	@Test
	public void registerNewAccountTheHardWay()
	{
		driver.get(HOME_PAGE_URL);
		driver.findElement(By.xpath("//a[@data-test='nav-sign-in']")).click();
		driver.findElement(By.xpath("//a[@data-test='register-link']")).click();
		driver.findElement(By.id("first_name")).sendKeys("Bob");
		driver.findElement(By.id("last_name")).sendKeys("Sponge");
		driver.findElement(By.id("dob")).sendKeys("04202000");
		driver.findElement(By.id("address")).sendKeys("124 Conch Street");
		driver.findElement(By.id("postcode")).sendKeys("90210");
		driver.findElement(By.id("city")).sendKeys("Bikini Bottom");
		driver.findElement(By.id("state")).sendKeys("American Samoa");
		driver.findElement(By.xpath("//option[text()='Mexico']")).click();
		driver.findElement(By.id("phone")).sendKeys("222333444");
		driver.findElement(By.id("email")).sendKeys("random+" + Math.random() + "@email.com");
		driver.findElement(By.id("password")).sendKeys("WelcomeR@nd0mCitiz3n!1");
		driver.findElement(By.xpath("//button[@data-test='register-submit']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//button[@class='google-sign-in-button']")).isDisplayed());
	}

	@Test
	public void buyProduct()
	{
		driver.get(HOME_PAGE_URL);
		driver.findElement(By.xpath("//h5[contains(text(),'Bolt Cutters')]")).click();
		driver.findElement(By.xpath("//button[@data-test='increase-quantity']")).click();
		driver.findElement(By.xpath("//button[@data-test='increase-quantity']")).click();
		driver.findElement(By.xpath("//button[@data-test='add-to-cart']")).click();
		driver.findElement(By.xpath("//a[@data-test='nav-cart']")).click();
		driver.findElement(By.xpath("//button[@data-test='proceed-1']")).click();
		driver.findElement(By.id("email")).sendKeys(CUSTOMER_EMAIL_ADDRESS);
		driver.findElement(By.id("password")).sendKeys(CUSTOMER_PASSWORD);
		driver.findElement(By.xpath("//input[@data-test='login-submit']")).click();
		driver.findElement(By.xpath("//button[@data-test='proceed-2']")).click();
		driver.findElement(By.id("address")).clear();
		driver.findElement(By.id("address")).sendKeys("Wiener Strasse 13");
		driver.findElement(By.id("city")).clear();
		driver.findElement(By.id("city")).sendKeys("Ingolstadt");
		driver.findElement(By.id("state")).clear();
		driver.findElement(By.id("state")).sendKeys("Bavaria");
		driver.findElement(By.id("country")).clear();
		driver.findElement(By.id("country")).sendKeys("Germany");
		driver.findElement(By.id("postcode")).clear();
		driver.findElement(By.id("postcode")).sendKeys("90210");
		driver.findElement(By.xpath("//button[@data-test='proceed-3']")).click();
		driver.findElement(By.xpath("//option[text()='Credit Card']")).click();
		driver.findElement(By.id("credit_card_number")).sendKeys("1234-4321-5678-8765");
		driver.findElement(By.id("expiration_date")).sendKeys("07/2030");
		driver.findElement(By.id("cvv")).sendKeys("555");
		driver.findElement(By.id("card_holder_name")).sendKeys("John Howe");
		driver.findElement(By.xpath("//button[@data-test='finish']")).click();
		Assert.assertTrue("Payment was successful".equals(driver.findElement(By.xpath("//div[@class='help-block']")).getText()));
	}
}