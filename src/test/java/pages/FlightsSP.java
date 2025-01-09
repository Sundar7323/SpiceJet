package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.spicebase;

public class FlightsSP extends spicebase{
	
	@FindBy(xpath="//div[@class=\"css-1dbjc4n r-1awozwy r-1xfd6ze r-1loqt21 r-18u37iz r-1777fci r-1w50u8q r-ah5dr5 r-1otgn73\"]") WebElement Continue;
	
	WebDriver driver;
	public FlightsSP(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public PassengersSP SelFlight() {
		Continue.click();
		return new PassengersSP(driver);
	}

}
