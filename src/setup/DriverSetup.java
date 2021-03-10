package setup;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSetup 
{
	//after deciding browser type, call actual method to launch site 
	public WebDriver initDriver(String browserName) throws IOException
	{
		WebDriver driver = null;
		String getBrowser = browserName.toLowerCase();
		
		//to decide browser
		switch (getBrowser) 
		{
		case "chrome": 
			driver = ChromeDriver();
			break;
		
		case "firefox": 
			driver = FirefoxDriver();
			break;
		}
		
		return driver;
	}
	
	//launch Chrome browser
	public WebDriver ChromeDriver() throws IOException 
	{
		//Load config.properties file to read data
		File src = new File("./properties/config.properties");
        FileInputStream fis = new FileInputStream(src);
        Properties pro = new Properties();
        pro.load(fis);
        
        //launch site
        String driverPath = pro.getProperty("DRIVER_PATH");
        System.setProperty("webdriver.chrome.driver", driverPath);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(pro.getProperty("LAUNCH_URL"));
        
        return driver;
     }
	
	//launch Firefox browser
	public WebDriver FirefoxDriver() throws IOException 
	{
		//Load config.properties file to read data
		File src = new File("./properties/config.property");
        FileInputStream fis = new FileInputStream(src);
        Properties pro = new Properties();
        pro.load(fis);

        // launch site
        String driverPath = pro.getProperty("DRIVER_PATH");
        System.setProperty("webdriver.gecko.driver", driverPath);
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(pro.getProperty("LAUNCH_URL"));
        
        return driver;
     }
}