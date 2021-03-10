package pages.summary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.HandleElement;

public class SummaryPage {

	WebDriver driver;
	HandleElement handleElement;
	
	public SummaryPage(WebDriver driver)
	{
        this.driver = driver;
        handleElement = new HandleElement(driver);
    }
	
	public void verifySummaryPage()
	{
		By verify_summary_page_locator = By.xpath("//span[text()='All channel subscribers']");
		handleElement.waitVisibilityOf(verify_summary_page_locator);
	}	

}
