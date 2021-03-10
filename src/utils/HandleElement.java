package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandleElement {
	
	WebDriver driver;
	WebElement we;
	
	public HandleElement(WebDriver driver)
	{
        this.driver = driver;
    }
	
	public void waitVisibilityOf(By locator) 
	{
		try 
		{
			we = new WebDriverWait(driver, 25)
			        .until(ExpectedConditions.visibilityOfElementLocated(locator));
		}
		catch(TimeoutException e) 
		{
			System.out.println("Time out and element not found : " + e);
		}
	}
	
	public void waitClickabilityOf(By locator) 
	{
		try 
		{
			we = new WebDriverWait(driver, 25)
			        .until(ExpectedConditions.elementToBeClickable(locator));
		}
		catch(TimeoutException e) 
		{
			System.out.println("Time out and element not found : " + e);
		}
	}
	
	public void waitVisibilityAndSendKeysOf(By locator, String theKeys) 
	{
		try 
		{
			we = new WebDriverWait(driver, 25)
			        .until(ExpectedConditions.visibilityOfElementLocated(locator));
			we.clear();
            we.sendKeys(theKeys);
		}
		catch(TimeoutException e) 
		{
			System.out.println("Time out and element not found : " + e);
		}
	}
	
	public void sendKeysOn(By locator, String theKeys) 
	{
		try 
		{
			we = driver.findElement(locator);
			we.clear();
			we.sendKeys(theKeys);
		}
		catch(NoSuchElementException e) 
		{
			System.out.println("Element not found : " + e);
		}
	}
	
	public void clickOn(By locator) 
	{
		try 
		{
			we = driver.findElement(locator);
			we.click();
		}
		catch(NoSuchElementException e) 
		{
			System.out.println("Element not found : " + e);
		}
	}
}