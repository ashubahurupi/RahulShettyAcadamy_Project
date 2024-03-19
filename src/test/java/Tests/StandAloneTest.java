package Tests;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import POM.LoginPage;
import Utilities.ScrollingView;
import pojo.Browser;

public class StandAloneTest extends Browser {
	public LoginTest LoginTest;
	
	
	@Test
	public void LoginwithInvalidCredentials()
	{
		LoginTest.loginWithInvalidCredentilas();
		
	}
	
	@Test
	public void StandAlone() throws InterruptedException {
		
		String productName="ZARA COAT 3";
	    LoginTest=new LoginTest();
		LoginTest.loginwithValidCredentials();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
		// Iterate each and every product 
		WebElement prod=products.stream().filter(product ->
		product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
		
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
	
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='toast-container']")));
		
		WebElement addToCartButton=driver.findElement(By.xpath("(//button[@class='btn btn-custom'])[3]"));
		Thread.sleep(2000);
		addToCartButton.click();
		
        List <WebElement> cartProducts=driver.findElements(By.xpath("//div[@class='cartSection']/h3"));		
        boolean match=cartProducts.stream().anyMatch(cartProduct ->cartProduct.getText().equalsIgnoreCase(productName));
        
        Assert.assertTrue(match);
        
        driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[3]")).click();
        Thread.sleep(2000);
       WebElement selectCountry=driver.findElement(By.xpath("//input[@placeholder='Select Country']"));
       
       Actions act=new Actions(driver);
       act.sendKeys(selectCountry, "india").build().perform();
       wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".ta-results")));
       
      driver.findElement(By.xpath("(//button[@class='ta-item list-group-item ng-star-inserted'])[2]")).click();
      Thread.sleep(2000);
      
      ScrollingView scrolling=new ScrollingView();
      WebElement placeOrder=driver.findElement(By.xpath("//a[text()='Place Order ']"));
      ScrollingView.scrollingView(driver, placeOrder);
      Thread.sleep(2000);
      placeOrder.click();
      
      Thread.sleep(2000);
      String confirmaMessage=driver.findElement(By.xpath("//td[@class='box']//h1")).getText();
      String expectedMessage="THANKYOU FOR THE ORDER.";
      Assert.assertEquals(confirmaMessage, expectedMessage);
      
      
		
	}

}
