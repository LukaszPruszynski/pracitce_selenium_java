package com.practicesoftwaretesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.practicesoftwaretesting.config.Customer;
import com.practicesoftwaretesting.pages.HomePage;
import com.practicesoftwaretesting.pages.account.MyAccountPage;

import io.github.bonigarcia.wdm.WebDriverManager;


@Test()
public class WaitUntilTests
{

	WebDriver driver;
	WebDriverWait wait;
	private final String HOME_PAGE_URL = "https://practicesoftwaretesting.com/#/";
	private final String CUSTOMER_EMAIL_ADDRESS = "customer2@practicesoftwaretesting.com";
	private final String CUSTOMER_PASSWORD = "welcome01";

	@BeforeTest
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}

	@Test
	public void loginWithCorrectCredentialsTheHardWay()
	{
		driver.get(HOME_PAGE_URL);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@data-test='search-submit']")));
		driver.findElement(By.xpath("//a[@data-test='nav-sign-in']")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@data-test='login-submit']")));
		driver.findElement(By.id("email")).sendKeys(CUSTOMER_EMAIL_ADDRESS);
		driver.findElement(By.id("password")).sendKeys(CUSTOMER_PASSWORD);
		driver.findElement(By.xpath("//input[@data-test='login-submit']")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@data-test='nav-favorites']")));
		Assert.assertTrue(driver.findElement(By.xpath("//h1[@data-test='page-title']")).isDisplayed());
	}

	@Test
	public void loginWithInCorrectCredentialsTheHardWay()
	{
		driver.get(HOME_PAGE_URL);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@data-test='search-submit']")));
		driver.findElement(By.xpath("//a[@data-test='nav-sign-in']")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@data-test='login-submit']")));
		driver.findElement(By.id("email")).sendKeys("invalid@email.com");
		driver.findElement(By.id("password")).sendKeys("S@mplePassword1");
		driver.findElement(By.xpath("//input[@data-test='login-submit']")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@data-test='login-error']")));
		Assert.assertTrue(driver.findElement(By.xpath("//div[@data-test='login-error']")).isDisplayed());
	}

	@Test
	public void registerNewAccountTheHardWay()
	{
		driver.get(HOME_PAGE_URL);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@data-test='search-submit']")));
		driver.findElement(By.xpath("//a[@data-test='nav-sign-in']")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@data-test='login-submit']")));
		driver.findElement(By.xpath("//a[@data-test='register-link']")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@data-test='register-submit']")));
		driver.findElement(By.id("first_name")).sendKeys("Alaska");
		driver.findElement(By.id("last_name")).sendKeys("Alaska");
		driver.findElement(By.id("dob")).sendKeys("04202000");
		driver.findElement(By.id("address")).sendKeys("124 Conch Street");
		driver.findElement(By.id("postcode")).sendKeys("90210");
		driver.findElement(By.id("city")).sendKeys("Fairbanks");
		driver.findElement(By.id("state")).sendKeys("Alaska");
		driver.findElement(By.xpath("//option[text()='Hungary']")).click();
		driver.findElement(By.id("phone")).sendKeys("222333444");
		driver.findElement(By.id("email")).sendKeys("random01@email.com");
		driver.findElement(By.id("password")).sendKeys("WelcomeR@nd0mCitiz3n!1");
		driver.findElement(By.xpath("//button[@data-test='register-submit']")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@data-test='login-submit']")));
		Assert.assertTrue(driver.findElement(By.xpath("//button[@class='google-sign-in-button']")).isDisplayed());
	}

	@Test
	public void buyProduct()
	{
		driver.get(HOME_PAGE_URL);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//a[contains(@data-test,'product')]")));
		driver.findElement(By.xpath("//h5[contains(text(),'Bolt Cutters')]")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='input-group quantity']/descendant::button")));
		driver.findElement(By.xpath("//button[@data-test='increase-quantity']")).click();
		driver.findElement(By.xpath("//button[@data-test='increase-quantity']")).click();
		driver.findElement(By.xpath("//button[@data-test='add-to-cart']")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@data-test='cart-quantity']")));
		driver.findElement(By.xpath("//a[@data-test='nav-cart']")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tbody")));
		driver.findElement(By.xpath("//button[@data-test='proceed-1']")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@data-test='login-submit']")));
		driver.findElement(By.id("email")).sendKeys(CUSTOMER_EMAIL_ADDRESS);
		driver.findElement(By.id("password")).sendKeys(CUSTOMER_PASSWORD);
		driver.findElement(By.xpath("//input[@data-test='login-submit']")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@data-test='proceed-2']")));
		driver.findElement(By.xpath("//button[@data-test='proceed-2']")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//form")));
		driver.findElement(By.id("address")).sendKeys("Wiener Strasse 13");
		driver.findElement(By.id("city")).sendKeys("Ingolstadt");
		driver.findElement(By.id("state")).sendKeys("Bavaria");
		driver.findElement(By.id("country")).sendKeys("Germany");
		driver.findElement(By.id("postcode")).sendKeys("90210");
		driver.findElement(By.xpath("//button[@data-test='proceed-3']")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[text()='Payment']")));
		driver.findElement(By.xpath("//option[text()='Credit Card']")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input")));
		driver.findElement(By.id("credit_card_number")).sendKeys("1234-4321-5678-8765");
		driver.findElement(By.id("expiration_date")).sendKeys("07/2030");
		driver.findElement(By.id("cvv")).sendKeys("555");
		driver.findElement(By.id("card_holder_name")).sendKeys("John Howe");
		driver.findElement(By.xpath("//button[@data-test='finish']")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='help-block']")));
		Assert.assertTrue("Payment was successful".equals(driver.findElement(By.xpath("//div[@class='help-block']")).getText()));
	}

	@Test
	public void explicitWithOptions() {
		driver.get("https://www.selenium.dev/selenium/web/dynamic.html");
		WebElement revealed = driver.findElement(By.id("revealed"));
		driver.findElement(By.id("reveal")).click();

		Wait<WebDriver> wait =
				new FluentWait<>(driver)
						.withTimeout(Duration.ofSeconds(2))
						.pollingEvery(Duration.ofMillis(300))
						.ignoring(ElementNotInteractableException.class);

		wait.until(
				d -> {
					revealed.sendKeys("Displayed");
					return true;
				});

		Assert.assertEquals("Displayed", revealed.getDomProperty("value"));
	}
}