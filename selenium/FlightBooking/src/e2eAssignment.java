import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class e2eAssignment {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\selenium\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice");
		WebElement option= driver.findElement(By.xpath("//div[@class='block large-row-spacer']/div[4]/fieldset/label[2]"));
		String Actualtext= driver.findElement(By.xpath("//div[@class='block large-row-spacer']/div[4]/fieldset/label[2]")).getText();
		option.click();
		
		Select opt=new Select(driver.findElement(By.id("dropdown-class-example")));
		opt.selectByVisibleText(option.getText());
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys(option.getText());
		driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
		Thread.sleep(2000);
	   
	    String Alerttext=driver.switchTo().alert().getText();
		
		
		if(Alerttext.contains(Actualtext))
		{
			System.out.println("Alert has the selected option");
			
		}
		else
		{
			System.out.println("Alert doesnt has the selected option");
		}
		
		
	
	

	}

}
