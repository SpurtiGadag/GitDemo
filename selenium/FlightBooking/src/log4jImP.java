import java.lang.System.Logger;
import java.util.logging.LogManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class log4jImP {
	private static java.util.logging.Logger log =LogManager.getLogger(act.class.getName());
	
	public static void main(String[] args) {
		((Object) log).debug("Setting chrome driver property");
		System.setProperty("webdriver.chrome.driver","C:\\selenium\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		   log.info("Window Maximized");
		   ((Object) log).debug("Now hitting Amazon server");
		   driver.get("https://www.amazon.com/");
		   log.info("Landed on amazon home page");
		   Actions a =new Actions(driver);
		   driver.get("http://jqueryui.com/demos/droppable/");
		   ((Object) log).debug("Getting the frames count");
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		log.info("Frames count retreived");
		try
		{
		driver.switchTo().frame(0);
		log.info("Successfully switched to frame");
		}
		catch(Exception e)
		{
		log.error("Cannot identify the frame"); 
		}
		//driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
		   log.debug("Identifying Draggable objects");
		       WebElement draggable = driver.findElement(By.id("draggable"));
		       WebElement droppable = driver.findElement(By.id("droppable"));
		       new Actions(driver).dragAndDrop(draggable, droppable).build().perform();
		log.info("Drag and drop success");
		       

	}

}
