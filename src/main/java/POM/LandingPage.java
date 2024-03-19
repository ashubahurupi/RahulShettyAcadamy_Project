package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponants.AbstractComponant;


public class LandingPage extends AbstractComponant{
  public WebDriver driver;
	// EnterUserName
	@FindBy(xpath="//input[@id='userEmail']") WebElement userEmail;
	//EnterPassword
	@FindBy(xpath="//input[@id='userPassword']") WebElement password;
	// login
	@FindBy(xpath="//input[@id='login']") WebElement loginButton;

	public LandingPage(WebDriver driver)
	{
		super(driver);
		// Initialization
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	public void loginApplication(String email, String pass)
	{
		userEmail.sendKeys(email);
		password.sendKeys(pass);
		loginButton.click();
	}
	
}
