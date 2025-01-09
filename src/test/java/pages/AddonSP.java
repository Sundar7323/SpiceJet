package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.spicebase;

public class AddonSP extends spicebase{
	
	@FindBy(xpath="//div[@data-testid='add-ons-continue-footer-button']") WebElement ClkContinue;
	@FindBy(xpath="//div[@class='css-1dbjc4n r-1loqt21 r-5scogr r-u8s1d r-v2u3o6 r-s5r7i3 r-1otgn73 r-8fdsdq']") WebElement Close;
	
	WebDriver driver;
	public AddonSP(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public PaymentSP Addons() {
		ClkContinue.click();
		Close.click();
		return new PaymentSP(driver);
	}

	
}
