package objectrepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RediffLoginPage {
	WebDriver driver;
	public RediffLoginPage( WebDriver driver)
	{
		this.driver=driver;
	}
	By username=By.xpath("//input[@id='login1']");
	By Password=By.id("password");
	By submit=By.name("proceed");
	
	public WebElement emailid()
	{
		return(driver.findElement(username));
	}
	public WebElement password()
	{
		return(driver.findElement(Password));
		
	}
	public WebElement submit()
	{
		return(driver.findElement(submit));
		
	}
	
	
}
