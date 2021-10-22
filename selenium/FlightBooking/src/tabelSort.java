import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class tabelSort {
	public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver","C:\\selenium\\chromedriver_win32 (1)\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	String[] itemsneeded= {"Cucumber","Pumpkin","Beetroot","Brinjal","Nushroom","Walnuts"};
	driver.get("https://rahulshettyacademy.com/seleniumPractise");
	Thread.sleep(3000);
	additems(driver,itemsneeded);
	//checkout(driver,countoptions);
	WebDriverWait W = new WebDriverWait(driver,10);
	driver.findElement(By.xpath("//img[@alt='Cart']")).click();
	
	driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
	//WebDriverWait w=new WebDriverWait(driver,5);
	//w.until(ExpectedConditions.elementToBeClickable(null))
	List<WebElement> Items= driver.findElements(By.xpath("//tr/td[2]"));
	List <String> getList=Items.stream().map(s->s.getText()).collect(Collectors.toList());
	//String[] actualname=getList.
	 //getList.stream().sorted().forEach(s->System.out.println(s));
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
} }  