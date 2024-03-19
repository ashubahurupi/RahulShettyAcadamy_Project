package Utilities;

import java.util.Date;

public class GetDateAndTime {
	
	
	public static String DateAndTime()
	{
		Date date=new Date();
		String TimeStamp=date.toString().replace(" ", "_").replace(":", "_");
		return "ashish"+TimeStamp+"@yopmail.com";
		
	}

}
