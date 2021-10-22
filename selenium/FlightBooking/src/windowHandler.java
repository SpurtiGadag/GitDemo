import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class windowHandler {

	public static void main(String[] args) {
	
			System.setProperty("webdriver.chrome.driver","C:\\selenium\\chromedriver_win32 (1)\\chromedriver.exe");
			WebDriver driver=new ChromeDriver(); 
			driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
			driver.findElement(By.xpath("//a[@class='blinkingText']")).click();
			Set<String> windows =driver.getWindowHandles();
			Iterator<String> it=windows.iterator();
			String parentWindow=it.next();
			String ChildWindow=it.next();
			driver.switchTo().window(ChildWindow);
			WebElement name= driver.findElement(By.xpath("//a[contains(text(),'mentor@rahulshettyacademy.com')]"));
			String email=name.getText();
			String[] actname=name.getText().split("@");
			 System.out.println(actname[1].trim());
			 driver.switchTo().window(parentWindow);
			 driver.findElement(By.id("username")).sendKeys(email);
			

	}

}
