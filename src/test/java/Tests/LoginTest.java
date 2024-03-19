package Tests;

import org.testng.annotations.Test;

import POM.LoginPage;
import pojo.Browser;

public class LoginTest extends Browser {
	
	@Test
	public void loginWithInvalidCredentilas()
	{
		LoginPage loginPage=new LoginPage(driver);
		loginPage.EnterEmaiId("abahurup@yopmail.com");
		loginPage.EnterPassword("Ashish@1234");
		loginPage.ClickOnLoginbutton();
		loginPage.errorMessageValidation();
	}

	public void loginwithValidCredentials() {
		LoginPage loginPage=new LoginPage(driver);
		loginPage.EnterEmaiId("abahurupi@yopmail.com");
		loginPage.EnterPassword("Ashish@1234");
		loginPage.ClickOnLoginbutton();
		
	}
	

}
