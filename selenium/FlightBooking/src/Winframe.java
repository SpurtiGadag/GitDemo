import java.awt.Desktop.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Winframe {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\selenium\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://jqueryui.com/droppable/");
		driver.switchTo().frame(0);
		//driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		driver.findElement(By.id("draggable")).click();
		Actions a=new Actions(driver);
		
        a.dragAndDrop(driver.findElement(By.id("draggable")),driver.findElement(By.id("droppable"))).build().perform() ;
        driver.switchTo().defaultContent();
	}

}
