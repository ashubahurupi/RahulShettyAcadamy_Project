package Tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import POM.LandingPage;
import POM.ProductCatelogue;
import POM.checkOutPage;
import Utilities.ScrollingView;
import pojo.Browser;

public class submitOrderTest extends Browser {
	public ProductCatelogue ProductCatelogue;
	
	@Test(priority=0,dataProvider="getData")
	public void SubmitOrderTest(String email, String Pass, String productName) throws InterruptedException {
		
		//String productName="ZARA COAT 3";
	
		// Launch the Application 
	  LandingPage LandingPage=new LandingPage(driver);
	  LandingPage.loginApplication(email,Pass);
	  ProductCatelogue=new ProductCatelogue(driver);
	  List<WebElement> products=ProductCatelogue.GetProductList();
	  ProductCatelogue.addProductToCart(productName);
	  ProductCatelogue.ClickOnAddToCartButton();
	  Boolean match=ProductCatelogue.verifyProductDisplay(productName);
      Assert.assertTrue(match);
      checkOutPage checkOut=new checkOutPage(driver);
      checkOut.ClickOnCheckOutButton();
      Thread.sleep(2000);
      checkOut.CheckOutPage();
      checkOut.ClickonPlaceOrderButton();    
      Thread.sleep(2000);
      String confirmaMessage=driver.findElement(By.xpath("//td[@class='box']//h1")).getText();
      String expectedMessage="THANKYOU FOR THE ORDER.";
      Assert.assertEquals(confirmaMessage, expectedMessage);
      
	}
	
	@Test(priority=1)
	public void OrderHistoryPage() throws InterruptedException
	{
		Thread.sleep(5000);
		ProductCatelogue.orderHistory();
		String productName1=ProductCatelogue.productName.getText();
		Assert.assertEquals(productName1, "ZARA COAT 3");
	}
	
	
	@DataProvider
	public Object[][] getData()
	{
		return new Object[][] {{"abahurupi@yopmail.com","Ashish@1234","ZARA COAT 3"},{"abahurupi001@yopmail.com","Ashish@12345","ADIDAS ORIGINAL"}};
		
	}
	
	
	
}
