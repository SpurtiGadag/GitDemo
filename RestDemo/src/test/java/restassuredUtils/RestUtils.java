package restassuredUtils;



import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {
	
	public static String getid()
	{
		String generatedString =RandomStringUtils.randomAlphabetic(1);
		return("1"+generatedString);
				
	}
	
	public static String petgetId1()
	{
		String generatedString =RandomStringUtils.randomAlphabetic(2);
		return("1"+generatedString);
				
	}
	
	public static String quantiy()
	{
		String generatedString =RandomStringUtils.randomAlphabetic(3);
		return("1"+generatedString);
				
	}
	
	public static String getdate()
	{
		Date d=new Date();
		return(d.toString());
	}
	
	public static String Status()
	{
		return("placed");
	}
	public static String complete()
	{
		return("true");
	}
}
