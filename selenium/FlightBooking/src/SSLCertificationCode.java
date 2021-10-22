import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.apache.commons.io.FileUtils;

public class SSLCertificationCode {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub

		//SSl certificates

		//Desired capabilities=
		//general chrome profile
		DesiredCapabilities ch=DesiredCapabilities.chrome();
		//ch.acceptInsecureCerts();
		ch.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		ch.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

		//Belows to your local browser
		System.setProperty("webdriver.chrome.driver","C:\\selenium\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	
	//	driver.manage().deleteCookieNamed("sessionKey");
	
	//click on any link
		//login page- verify login url
		
		
		driver.get("http://google.com");
		
		File src=	 ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("C:\\Users\\SPKU\\screenshot.png"));
	


	}

}
