package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.spicebase;

public class FlightStatusSP extends spicebase{
	
	@FindBy(xpath="//div[text()=\"Home\"]") WebElement Home;
	
	WebDriver driver;
	public FlightStatusSP(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public HomepageSP gotoHome() {
		Home.click();
		return new HomepageSP(driver);
		
	}

}
