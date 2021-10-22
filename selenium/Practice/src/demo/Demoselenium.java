package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Demoselenium {

	public static void main(String[] args) {
	System.setProperty("webdriver.gecko.driver", "C:\\selenium\\geckodriver-v0.29.1-win64\\geckodriver.exe");	
		WebDriver driver = new FirefoxDriver();
		driver.get("http://vmiotspro98:5555/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		/*WebElement Uesername = driver.findElement(By.xpath("//input[@id='isac_usernameElementRef']"));
		Uesername.sendKeys("Administrator");
		WebElement Password = driver.findElement(By.xpath("//input[@id='isac_passwordFieldRef']"));
		Password.sendKeys("manage");
		WebElement loginbttn = driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
		loginbttn.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@id='profile-link']")).click();

		WebElement loggbttn = driver.findElement(By.xpath("//button[contains(text(),'Log out')]"));
		loggbttn.isDisplayed();
		System.out.println("LoggedIn");*/
		
		WebElement Uesername = driver.findElement(By.cssSelector("input[id='isac_usernameElementRef']"));
		Uesername.sendKeys("Administrator");
		WebElement Password = driver.findElement(By.cssSelector("input[id='isac_passwordFieldRef']"));
		Password.sendKeys("manage");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement loginbttn = driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
		loginbttn.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@id='profile-link']")).click();

		WebElement loggbttn = driver.findElement(By.xpath("//button[contains(text(),'Log out')]"));
		loggbttn.isDisplayed();
		System.out.println("LoggedIn");
		
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/app-root[1]/lib-masthead[1]/div[1]/nav[1]/div[1]/div[2]/lib-master-nav-primary-panel[1]/ul[1]/lib-master-nav-item[1]/li[1]/a[1]/span[1]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Monitoring')]")).click();
	
}
	
	

		
		
	}


