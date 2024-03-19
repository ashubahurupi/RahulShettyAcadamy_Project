package AbstractComponants;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AbstractComponant {
WebDriver driver;
	
 public AbstractComponant(WebDriver driver) {
		this.driver=driver;
	}

public void waitForElementToAppear(By productsBy)
 {
	 WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
	 wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productsBy));
 }


public void waitForElementToDisAppear(WebElement  ele)
{
	 WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));	 
	 wait.until(ExpectedConditions.invisibilityOf(ele));
}
}