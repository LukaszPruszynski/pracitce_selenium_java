package com.practicesoftwaretesting.pages;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import lombok.Getter;


@Getter
public class BasePage
{
	WebDriver driver;
	WebDriverWait wait;

	public BasePage(WebDriver driver, WebDriverWait wait)
	{
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);
	}

	public WebElement getElement(By by)
	{
		return driver.findElement(by);
	}

	public WebElement getElement(final String selector, final String text)
	{
		return driver.findElement(By.xpath(String.format(selector, text)));
	}

	public void waitForElement(WebElement webElement)
	{
		wait.until(d -> webElement.isDisplayed() && webElement.isEnabled());
	}

	public void waitForElementTest(By by)
	{
		wait.until(ExpectedConditions.elementToBeClickable(by));
	}

	public void waitForElementFluently(By by)
	{
		Wait<WebDriver> wait = new FluentWait<>(getDriver()).withTimeout(Duration.ofSeconds(15))
				.pollingEvery(Duration.ofMillis(1000)).ignoring(NoSuchElementException.class);

		wait.until(ExpectedConditions.presenceOfElementLocated(by));
	}

	public void waitForElementToDisappear(WebElement webElement)
	{
		wait.until(ExpectedConditions.invisibilityOf(webElement));
	}
}
