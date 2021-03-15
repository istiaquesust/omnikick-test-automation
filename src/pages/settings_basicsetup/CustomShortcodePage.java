package pages.settings_basicsetup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.HandleElement;
import utils.HandleElementByJS;

public class CustomShortcodePage {
	
	WebDriver driver;
	HandleElement handleElement;
	HandleElementByJS handleElementByJS;
	
	public CustomShortcodePage(WebDriver driver)
	{
        this.driver = driver;
      	handleElement = new HandleElement(driver);
      	handleElementByJS = new HandleElementByJS(driver);
    }
	
	public void navigateToCustomShortcodePage() 
	{
		driver.navigate().to("https://v2.omnikick.com/settings/basic/shortcode");
	}
	
	public void verifyCustomShortcodePage()
	{
		By verify_custom_shortcode_page_locator = By.xpath("//h2[text()='Custom Shortcode']");
		handleElement.waitVisibilityOf(verify_custom_shortcode_page_locator);
	}
	
	public void createShortcode() 
	{				
		By create_btn_locator = By.xpath("//*[@id=\"app\"]/div/div[4]/div/div[2]/div[1]/button");
		handleElement.clickOn(create_btn_locator);	
	}

	public void inputShortcodeName(String shortcode_name) 
	{				
		By shortcode_name_locator = By.xpath("//*[@id=\"app\"]/div/div[4]/div/div[2]/div[2]/form/div[1]/div[1]/input");
		handleElement.waitVisibilityAndSendKeysOf(shortcode_name_locator, shortcode_name);
	}
	
	public void inputShortcodeBody(String shortcode_body) 
	{				
		By shortcode_name_locator = By.xpath("//*[@id=\"app\"]/div/div[4]/div/div[2]/div[2]/form/div[2]/div/div/div[2]/div/p");
		handleElement.sendKeysOn(shortcode_name_locator, shortcode_body);
	}
	
	public void clickSave()
	{
		By save_button_locator = By.xpath("//button[contains(.,'Save Shortcode')]");
		handleElementByJS.scrollIntoViewAndClick(save_button_locator);
	}
	
	public void verifySave()
	{
		By verify_save_locator = By.xpath("//div[contains(.,'Successfully saved!')]");
		handleElement.waitVisibilityOf(verify_save_locator);
	}
}
