import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class multiWinAssig {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\selenium\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver=new ChromeDriver(); 
		driver.get("https://the-internet.herokuapp.com/windows");
		driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();
		Set<String> wind = driver.getWindowHandles();
		Iterator<String> window=wind.iterator();
		String parentwindow=window.next();
		String childwin=window.next();
		driver.switchTo().window(childwin);
		String childwintext=driver.findElement(By.xpath("//h3[contains(text(),'New Window')]")).getText();
		System.out.println(childwintext);
		driver.switchTo().window(parentwindow);
		WebDriverWait W=new WebDriverWait(driver,5);
		W.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(text(),'Opening a new window')]")));
		String parentWintext=driver.findElement(By.xpath("//h3[contains(text(),'Opening a new window')]")).getText();
		System.out.println(parentWintext);	
		
	
	}

}
