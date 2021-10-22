package commonlib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfigProperties {
	
	private Properties properties;
	
	public Properties initialize_properties() {
		
		properties = new Properties();
		try {
			FileInputStream readGlobalDataFromFile = new FileInputStream("resources/globalData.properties");
			properties.load(readGlobalDataFromFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return properties;
		
	}

}
