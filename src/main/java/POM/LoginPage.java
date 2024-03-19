package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

	public WebDriver driver;
	
	@FindBy(xpath="//input[@id='userEmail']") public WebElement emailIdField;
	@FindBy(xpath="//input[@id='userPassword']") public WebElement passwordField;
	@FindBy(xpath="//input[@id='login']") public WebElement Loginbutton;
	@FindBy(xpath="//div[@class='ng-tns-c4-4 toast-message ng-star-inserted']") public WebElement ErrorMessage;
	
	
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}

	public void EnterEmaiId(String emailId)
	{
		emailIdField.sendKeys(emailId);
		
	}
	
	public void EnterPassword(String password)
	{
		passwordField.sendKeys(password);
	}
	
	public void ClickOnLoginbutton()
	{
		Loginbutton.click();
	}

	public void errorMessageValidation()
	{
		
	}


}
