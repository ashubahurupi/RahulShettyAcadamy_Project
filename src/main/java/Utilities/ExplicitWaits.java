package Utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaits {
	
	public WebDriver driver;
	
	public WebElement Waits(int sec , WebElement Element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.visibilityOf(Element));
		return Element;
	}

}
