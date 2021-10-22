import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;


public class booking {
	

/*public static WebDriver getDriver()
{
	System.setProperty("webdriver.chrome.driver","C:\\selenium\\chromedriver_win32 (1)\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	return driver;
}
	public static void gotourl(String url)
	{
		getDriver().get(url);
		
		
	}*/
 /*public void navigateto(String key )
 {x
	 getDriver().find(By.xpath("key")).
 }*/
public static void main(String[] args) throws InterruptedException
{
	System.setProperty("webdriver.chrome.driver","C:\\selenium\\chromedriver_win32 (1)\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
	
	  driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
	  
	WebElement dropINR = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
	Select dropdown= new Select(dropINR);
	/*dropdown.selectByIndex(3);
	System.out.println(dropdown.getFirstSelectedOption().getText());*/
  dropdown.selectByValue("INR");
	System.out.println(dropdown.getFirstSelectedOption().getText());
	/*dropdown.selectByVisibleText("AED");
	System.out.println(dropdown.getFirstSelectedOption().getText());*/
   driver.findElement(By.id("divpaxinfo")).click();
   try {
	Thread.sleep(2000);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
    
   for(int i=0; i<=3; i++)
   {
	   driver.findElement(By.id("hrefIncAdt")).click();
	   
   }
   
   driver.findElement(By.id("btnclosepaxoption")).click();
   Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
   System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
 
   driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
   driver.findElement(By.xpath("//a[@value='BLR']")).click();
   Thread.sleep(2000);
     
   driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='MAA']")).click();
   Thread.sleep(2000);
   //WebElement date = driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active"));
   //Thread.sleep(2000);
   //date.click();
   
   driver.findElement(By.id("autosuggest")).sendKeys("ind");
   Thread.sleep(2000);
 List<WebElement> options =  driver.findElements(By.xpath("//li[@class='ui-menu-item']//a"));
 
 for (WebElement option: options)
 {
	 if (option.getText().equalsIgnoreCase("India"))
	 {
		 option.click();
		 break;
      }
 
 }
   driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();
   Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
   System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
   
 
   /*if((driver.findElement(By.id("Div1"))).getAttribute("style").contains("1"))
   {
	   System.out.println("Isenabled");
	   Assert.assertTrue(true);
   }
   else
   {
	   Assert.assertTrue(false);
   }*/
}

}
