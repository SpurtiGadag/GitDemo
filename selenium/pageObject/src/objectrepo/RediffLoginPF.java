package objectrepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RediffLoginPF {
	WebDriver driver;
	public RediffLoginPF( WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//input[@id='login1']")
	WebElement username;
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(name="proceed")
	WebElement submit;
	
	public WebElement emailid()
	{
		return(username);
	}
	public WebElement password()
	{
		return(password);
		
	}
	public WebElement submit()
	{
		return(submit);
		
	}
	
}
