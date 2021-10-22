import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class scrollWebpageJavascript {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\selenium\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,600)");
		Thread.sleep(2000);
		
js.executeScript("document.querySelector('.tableFixHead').scrollTop=500");


   System.out.println("Row Count"+driver.findElements(By.xpath("//table[@class='table-display']/tbody/tr")).size());
   System.out.println("Column Count"+driver.findElements(By.xpath("//table[@class='table-display']/tbody/tr/th")).size());
List<WebElement> content= driver.findElements(By.xpath("//table[@class='table-display']/tbody/tr[3]/td"));
for(int i=0;i<content.size();i++)
{
	System.out.println(content.get(i).getText());
}
   
   
   
	}

}