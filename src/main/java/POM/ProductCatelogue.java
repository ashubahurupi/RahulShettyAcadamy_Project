package POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import AbstractComponants.AbstractComponant;

public class ProductCatelogue extends AbstractComponant{
	
public WebDriver driver;
	
	@FindBy(css=".mb-3") List<WebElement> products;
	
	By productsBy=By.cssSelector(".mb-3");
	By addToCart=By.cssSelector(".card-body button:last-of-type");
	By toastMessage=By.xpath("//div[@id='toast-container']");
	
	@FindBy(xpath="(//button[@class='btn btn-custom'])[3]") public WebElement addToCartButton;
	
	@FindBy(xpath="//div[@class='cartSection']/h3")
	public List<WebElement> cartProducts;
	
	@FindBy(xpath="(//button[@class='btn btn-custom'])[2]") public WebElement OrderButton;
	
	@FindBy(xpath="//td[text()='ZARA COAT 3']") public WebElement productName;
	
	public ProductCatelogue(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}

	public List<WebElement> GetProductList()
	{
		waitForElementToAppear(productsBy);
		return products;
	}
	
	public WebElement getProductName(String productName)
	{
		// Iterate each and every product 
		WebElement prod=GetProductList().stream().filter(product ->
		product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}
	
	public void addProductToCart(String productName) throws InterruptedException
	{
		WebElement prod=getProductName(productName);
		prod.findElement(addToCart).click();
		waitForElementToAppear(toastMessage);
	}
	
	public void ClickOnAddToCartButton() throws InterruptedException
	{
		Thread.sleep(2000);
		addToCartButton.click();
		
	}

	public boolean verifyProductDisplay(String productName) {
		 boolean match=cartProducts.stream().anyMatch(cartProduct ->cartProduct.getText().equalsIgnoreCase(productName));
		 
		 return match;
	}
	
	public void orderHistory()
	{
		OrderButton.click();
		
	}
	

}
