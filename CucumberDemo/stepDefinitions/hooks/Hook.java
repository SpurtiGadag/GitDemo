package hooks;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.paulhammant.ngwebdriver.NgWebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;



public class Hook {
	public static WebDriver driver =null;
	static Properties globalData=null;
	NgWebDriver ngWebDriver;
	JavascriptExecutor jsDriver;

    public Hook() throws IOException {
    	System.out.println(" Inside Hook Constructor");
    	FileReader reader=new FileReader("resources/globalData.properties"); 
		globalData=new Properties();  
		globalData.load(reader);
    	
		String browserName = globalData.getProperty("browserName");
     	if(driver == null) {
        	//WebDriverManager.firefoxdriver().setup();
    		//driver=new FirefoxDriver();
     		if(browserName.toUpperCase().equals("CHROME")) {
     			WebDriverManager.chromedriver().setup();
         		driver=new ChromeDriver();
         		driver.manage().window().maximize();
     		} else if(browserName.toUpperCase().equals("FIREFOX")) {
     			WebDriverManager.firefoxdriver().setup();
        		driver=new FirefoxDriver();
        		driver.manage().window().maximize();
     		} else {
     			System.out.println("Please choose valid browser name (Firefox or Chrome)");
     		}
     	}



    }


	@Before
	public void BeforeSteps() throws IOException {
		System.out.println("*************Before Scenario***********");
 	}


	@After
	public void AfterSteps() {
		System.out.println("*************After Scenario***********");
 
	}
 

	public static WebDriver getDriver() { 
		return driver;
	}

	public static Properties getGlobalData() { 
		return globalData;
	}
    
	public static void quitDriver() { 
		driver.quit();
		}
	public static void closeDriver() { 
		driver.close();
		}
	 

}