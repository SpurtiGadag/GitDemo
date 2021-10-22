package commonlib;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import org.openqa.selenium.WebDriver;

public class CMDLib {
	
	WebDriver driver;
	
	public CMDLib(WebDriver driver) {
		this.driver = driver;
	}
	
	public CMDLib() {
	}


	
	public void runCmd(String directory, String command) throws IOException, Exception 
	{
		File dir = new File(directory);
 		Process p = Runtime.getRuntime().exec(command, null, dir);
   
		BufferedWriter writeer = new BufferedWriter(new OutputStreamWriter(
				p.getOutputStream()));
		writeer.write("Just trial string");
		writeer.flush();

		BufferedReader stdInput = new BufferedReader(new InputStreamReader(
				p.getInputStream()));
		
		stdInput.close();
		writeer.close();
	}

}
