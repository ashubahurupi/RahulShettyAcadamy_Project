package Utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;


public class screenShots{
	
	public static  String getScreenShots(WebDriver driver, String fileName)
	{
		String dateAndTime=DateAndTime.Time();
		File sourceFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		// File extentReportFile=new File(System.getProperty("user.dir")+"\\ExtentsReport\\eReport.html");
		File targetFile=new File(System.getProperty("user.dir")+"\\Screenshots\\"+fileName+dateAndTime+".png");
		
		try {
			FileHandler.copy(sourceFile, targetFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.print("ScreenShot takes Succesfully");
		return targetFile.getAbsolutePath();
		
	}

}
