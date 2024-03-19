package pojo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;

public class Browser {
	public WebDriver driver;
	
	@BeforeClass
	public WebDriver launchbrowser() throws IOException
	{
		
		// Properties Class
		Properties prop=new Properties();
		
		File file=new File(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\GlobalData.properties");
		FileInputStream fis=new FileInputStream(file);
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
		driver=new ChromeDriver();
		
		String url=prop.getProperty("url");
		driver.get(url);
		
		
	    }
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
			driver.get("https://rahulshettyacademy.com/client");
		}
		
		else if(browserName.equalsIgnoreCase("Edge"))
		{
			driver=new EdgeDriver();
			driver.get("https://rahulshettyacademy.com/client");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	 
		return driver;
//	@AfterClass
//	public void QuitBrower()
//	{
//		driver.quit();
//	}
	} 
}
