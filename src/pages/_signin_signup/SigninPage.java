package pages._signin_signup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.HandleElement;

public class SigninPage {
	
	WebDriver driver;
	HandleElement handleElement;
	
	public SigninPage(WebDriver driver)
	{
        this.driver = driver;
        handleElement = new HandleElement(driver);
    }
	
	public void verifySigninPage()
	{
		By verify_login_page_locator = By.xpath("//button[text()='Sign in to Omnikick']");
		handleElement.waitVisibilityOf(verify_login_page_locator);		
	}
	
	public void setUserName(String user_name)
	{
		By user_name_locator = By.name("username");
		handleElement.sendKeysOn(user_name_locator, user_name);
	}
	
	public void setPassword(String password)
	{
		By pasword_locator = By.name("password");
		handleElement.sendKeysOn(pasword_locator, password);
	}
	
	public void clickSigninButton()
	{
		By login_button_locator = By.xpath("//button[text()='Sign in to Omnikick']");
		handleElement.clickOn(login_button_locator);
	}
	
}