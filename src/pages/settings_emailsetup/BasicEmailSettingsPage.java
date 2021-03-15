package pages.settings_emailsetup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.HandleElement;
import utils.HandleElementByJS;

public class BasicEmailSettingsPage {
	
	WebDriver driver;
	HandleElement handleElement;
	HandleElementByJS handleElementByJS;
	
	public BasicEmailSettingsPage(WebDriver driver)
	{
        this.driver = driver;
      	handleElement = new HandleElement(driver);
      	handleElementByJS = new HandleElementByJS(driver);
    }
	
	public void navigateToBasicEmailSettingsPage() 
	{
		driver.navigate().to("https://v2.omnikick.com/settings/email");
	}
	
	public void verifyBasicEmailSettingsPage()
	{
		By verify_basic_email_settings_page_locator = By.xpath("//h2[text()='Basic Email Settings']");
		handleElement.waitVisibilityOf(verify_basic_email_settings_page_locator);
	}	
	
	public void inputDefaultFromName(String default_from_name) 
	{				
		By default_from_name_locator = By.xpath("//*[@id=\"app\"]/div/div[4]/div/div[2]/form/div[1]/div[1]/div[1]/input");
		handleElement.sendKeysOn(default_from_name_locator, default_from_name);
	}
	
	public void inputDefaultFromEmail(String default_from_email) 
	{				
		By default_from_email_locator = By.xpath("//*[@id=\"app\"]/div/div[4]/div/div[2]/form/div[1]/div[1]/div[2]/input");
		handleElement.sendKeysOn(default_from_email_locator, default_from_email);
	}
	
	public void inputDefaultPostalAddress(String default_postal_address) 
	{				
		By default_postal_address_locator = By.xpath("//*[@id=\"app\"]/div/div[4]/div/div[2]/form/div[1]/div[2]/textarea");
		handleElement.sendKeysOn(default_postal_address_locator, default_postal_address);
	}
	
	public void clickSave()
	{
		By save_button_locator = By.xpath("//button[contains(.,'Save Settings')]");
		handleElementByJS.scrollIntoViewAndClick(save_button_locator);
	}
	
	public void verifySave()
	{
		By verify_save_locator = By.xpath("//div[contains(.,'Successfully saved!')]");
		handleElement.waitVisibilityOf(verify_save_locator);
	}

}
