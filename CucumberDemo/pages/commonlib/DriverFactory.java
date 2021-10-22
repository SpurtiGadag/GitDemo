package commonlib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public WebDriver driver;
	/*
	 *  This method is used to initialize webDriver passed 
	 *  via global data properties file.
	 */
	
	public WebDriver init_driver(String browser) {
		System.out.println("Initializing the "+browser+" browser");
		String brName = browser.toLowerCase();
		
		if(brName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver(); 
			
		} else if(brName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else
		{
			System.out.println("Please provide supported brower value chrome or firefox");
		}
		
		return driver;
	}
	
}
