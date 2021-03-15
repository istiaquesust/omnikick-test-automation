package pages.settings_basicsetup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.HandleElement;
import utils.HandleElementByJS;

public class GoogleAnalyticsPage {
	
	WebDriver driver;
	HandleElement handleElement;
	HandleElementByJS handleElementByJS;
	
	
	public GoogleAnalyticsPage(WebDriver driver)
	{
        this.driver = driver;
      	handleElement = new HandleElement(driver);
      	handleElementByJS = new HandleElementByJS(driver);
    }
	
	public void verifyGoogleAnalyticsPage()
	{
		By verify_google_analytics_page_locator = By.xpath("//h2[text()='Google Analytics']");
		handleElement.waitVisibilityOf(verify_google_analytics_page_locator);
	}
	
	public void navigateToSequenceMessage() 
	{
		driver.navigate().to("https://v2.omnikick.com/settings/basic");
	}
	
	public void navigateToBroadcastMessage() 
	{
		driver.navigate().to("https://v2.omnikick.com/settings/basic/broadcast");
	}
	
	public void navigateToAutomationMessage() 
	{
		driver.navigate().to("https://v2.omnikick.com/settings/basic/automation");
	}
	
	public void inputSource(String source)
	{
		By source_locator = By.xpath("//div[1]/div[2]/div[1]/div[1]/input");
		handleElement.sendKeysOn(source_locator, source);
	}
	
	public void inputMedium(String medium)
	{
		By medium_locator = By.xpath("//div[1]/div[2]/div[1]/div[2]/input");
		handleElement.sendKeysOn(medium_locator, medium);
	}
	
	public void selectCampaign()
	{
		By campaign_locator = By.xpath("//form/div[1]/div[2]/div[2]/div[1]/div/div/button");
		handleElement.clickOn(campaign_locator);
		
		// click on "none" type
		By campaign_type_locator = By.xpath("//div[1]/div[2]/div[2]/div[1]/div/div/ul/li[1]/a");
		handleElement.clickOn(campaign_type_locator);
	}

	public void selectContent()
	{
		By content_locator = By.xpath("//form/div[1]/div[2]/div[2]/div[2]/div/div/button");
		handleElement.clickOn(content_locator);
		
		// click on "none" type
		By content_type_locator = By.xpath("//div[1]/div[2]/div[2]/div[2]/div/div/ul/li[1]/a");
		handleElement.clickOn(content_type_locator);
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