package com.practicesoftwaretesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


@Test()
public class FluentWaitTests
{

	WebDriver driver;
	WebDriverWait wait;

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
	public void explicitWithOptions()
	{
		driver.get("https://www.selenium.dev/selenium/web/dynamic.html");
		WebElement revealed = driver.findElement(By.id("revealed"));
		driver.findElement(By.id("reveal")).click();

		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(2)).pollingEvery(Duration.ofMillis(300))
				.ignoring(ElementNotInteractableException.class);

		wait.until(d -> {
			revealed.sendKeys("Displayed");
			return true;
		});

		Assert.assertEquals("Displayed", revealed.getDomProperty("value"));
	}
}