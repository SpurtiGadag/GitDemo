import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Cartprac {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\selenium\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String[] itemsneeded= {"Cucumber","Pumpkin"};
		driver.get("https://rahulshettyacademy.com/seleniumPractise");
		Thread.sleep(3000);
		additems(driver,itemsneeded);
		//checkout(driver,countoptions);
		WebDriverWait W = new WebDriverWait(driver,10);
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		
		W.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='promoCode']")));
		driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[contains(text(),'Apply')]")).click();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		W.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Code applied ..!')]")));
		String msg= driver.findElement(By.xpath("//span[contains(text(),'Code applied ..!')]")).getText();
		Assert.assertTrue(msg.contains("Code applied ..!"));
		
		

		driver.findElement(By.xpath("//button[contains(text(),'Place Order')]")).click();
		Thread.sleep(2000);
		WebElement countoptions = driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/div[1]/select[1]"));
		Select opt = new Select(countoptions);
				opt.selectByValue("India");
				
		
				driver.findElement(By.xpath("//input[@type='checkbox']")).click();
				
				driver.findElement(By.xpath("//button[contains(text(),'Proceed')]")).click();
				//driver.manage().A
	}		
public static void additems(WebDriver driver,String[] itemsneeded )	
{
	
   int j=0;
	List<WebElement> prods=driver.findElements(By.xpath("//h4[@class='product-name']"));
    for (int i=0; i<prods.size();i++)
    {
  	 //String prodname= prods.get(i).getText();
  	  String[] name=prods.get(i).getText().split("-"); 
  	  String formattedString=name[0].trim();
  	 List<String> itemlist=Arrays.asList(itemsneeded);
  	
  	 if (itemlist.contains(formattedString))
  			 {
  		          j++;
  		       driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
  		       if(j==itemlist.size())
  		    		   
  		    		   {break;}
  			 }
    
    }
}   
		
/*public static void checkout(WebDriver driver,WebElement countoptions) throws InterruptedException
{
	driver.findElement(By.xpath("//img[@alt='Cart']")).click();
	
	driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahulshettyacademy");
	
	Thread.sleep(2000);
	driver.findElement(By.xpath("//button[contains(text(),'Place Order')]")).click();
	Thread.sleep(2000);
	
	Select opt = new Select(countoptions);
			opt.selectByValue("India");
			driver.findElement(By.xpath("//button[contains(text(),'Proceed')]")).click();
}
*/
      
	
	
}
