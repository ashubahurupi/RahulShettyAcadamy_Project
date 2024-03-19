package Utilities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateAndTime {
	
	public static String Time()
	{
		LocalDateTime dateTime=LocalDateTime.now();
		
		DateTimeFormatter pattern =DateTimeFormatter.ofPattern("dd-mm-yyyy-HH-mm-ss");
		
		String time=dateTime.format(pattern);
		return time;
		
	}

}
