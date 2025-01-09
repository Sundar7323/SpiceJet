package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.spicebase;

public class PaymentSP extends spicebase{
	
	@FindBy(xpath="//div[@data-testid='select-upi']") WebElement UPI;
	
	@FindBy(xpath="//div[@data-testid='common-proceed-to-pay']") WebElement Proceedtopay;
	
	@FindBy(id="close") WebElement Close;
	
	@FindBy(xpath="//div[@class='css-76zvg2 r-poiln3 r-1b6yd1w']") WebElement Failure;
	
	@FindBy(xpath="//div[@class='css-76zvg2 r-poiln3 r-1enofrn r-1ddef8g']") WebElement Home;
	
	
	WebDriver driver;
	public PaymentSP(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public PaymentfailureSP payment() {
		
	       UPI.click();
	       Proceedtopay.click();
	       Close.click();
	       return new PaymentfailureSP(driver);
	}   
	
	
}
