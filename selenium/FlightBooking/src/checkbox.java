import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class checkbox {
	
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver","C:\\selenium\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).isSelected());
		driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).click();
		Assert.assertFalse(driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).isSelected());
		System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());
	}

}
