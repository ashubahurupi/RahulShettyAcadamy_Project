package Utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScrollingView {

	public static  WebDriver driver;
	
	public static WebElement scrollingView(WebDriver driver, WebElement element ) {
		
       JavascriptExecutor js=(JavascriptExecutor)driver;
		           
		
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		
		return element;
		
	}

	public void scrollingAtTop() {
		 JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,0)");
		
	}

}
