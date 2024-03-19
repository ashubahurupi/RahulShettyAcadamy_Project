package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import AbstractComponants.AbstractComponant;
import Utilities.ScrollingView;

public class checkOutPage extends AbstractComponant{

	WebDriver driver;
	public checkOutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="(//button[@class='btn btn-primary'])[3]") public WebElement checkoutButton;
	
	@FindBy(xpath="(//input[@class='input txt text-validated'])[2]") public WebElement clickOnCountryDropdown;
	
	@FindBy(xpath="//input[@placeholder='Select Country']") public WebElement selectCountry;
	
	@FindBy(xpath="//a[@class='btnn action__submit ng-star-inserted']") public WebElement placeOrder;
	
	@FindBy(xpath="(//button[@class='ta-item list-group-item ng-star-inserted'])[2]") public WebElement selectDropdownOption;
	
	@FindBy(xpath="//a[text()='Place Order ']") public WebElement placeholderbutton;
	
	public void ClickOnCheckOutButton() {
		checkoutButton.click();
		
	}
	
	public void CheckOutPage() throws InterruptedException
	{
		clickOnCountryDropdown.click();
		Thread.sleep(2000);
		Actions act=new Actions(driver);
		act.sendKeys(selectCountry, "India").build().perform();
		selectDropdownOption.click();
	}
	 
	public void ClickonPlaceOrderButton()
	{
		ScrollingView scrolling=new ScrollingView();
		scrolling.scrollingView(driver, placeholderbutton);
		placeholderbutton.click();
	}
	
	public void thankYouPage()
	{
		
	}

 
//  ScrollingView scrolling=new ScrollingView();
//  WebElement placeOrder=driver.findElement(By.xpath("//a[text()='Place Order ']"));
//  ScrollingView.scrollingView(driver, placeOrder);
//  Thread.sleep(2000);
//  placeOrder.click();
//  
//  Thread.sleep(2000);
//  String confirmaMessage=driver.findElement(By.xpath("//td[@class='box']//h1")).getText();
//  String expectedMessage="THANKYOU FOR THE ORDER.";
//
//  Assert.assertEquals(confirmaMessage, expectedMessage);

}
