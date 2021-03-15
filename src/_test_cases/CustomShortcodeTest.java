package _test_cases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import pages._signin_signup.SigninPage;
import pages.settings_basicsetup.CustomShortcodePage;
import pages.summary.SummaryPage;
import setup.DriverSetup;

public class CustomShortcodeTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//Load config.properties file to read data
		File src = new File("./properties/config.properties");
		FileInputStream fis = new FileInputStream(src);
		Properties pro = new Properties();
		pro.load(fis);	
						
		//Driver Setup
		DriverSetup setup = new DriverSetup();
		WebDriver driver = setup.initDriver(pro.getProperty("BROWSER_NAME"));		
						
		//Signin
		SigninPage signin = new SigninPage(driver);
		signin.verifySigninPage();
		signin.setUserName(pro.getProperty("USER_NAME"));
		signin.setPassword(pro.getProperty("PASSWORD"));
		signin.clickSigninButton();
						
		//verify login
		SummaryPage summary = new SummaryPage(driver);
		summary.verifySummaryPage();
		
		//shortcode
		CustomShortcodePage cs = new CustomShortcodePage(driver);
		cs.navigateToCustomShortcodePage();
		cs.verifyCustomShortcodePage();
		cs.createShortcode();
		cs.inputShortcodeName(pro.getProperty("SHORTCODE_NAME"));
		cs.inputShortcodeBody(pro.getProperty("SHORTCODE_BODY"));
		cs.clickSave();
		cs.verifySave();
		
		driver.quit();

	}

}
