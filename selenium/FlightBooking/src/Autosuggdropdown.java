import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Autosuggdropdown {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\selenium\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("autocomplete")).sendKeys("ind");
		Thread.sleep(2000);
		List<WebElement> options=driver.findElements(By.xpath("//li[@class='ui-menu-item']"));
				for(WebElement opt :options)
				{
					if(opt.getText().equalsIgnoreCase("India"))
					{
						opt.click();
						break;
					}
				}

	}

}
