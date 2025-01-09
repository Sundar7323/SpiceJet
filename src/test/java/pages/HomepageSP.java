package pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.spicebase;

public class HomepageSP extends spicebase{
	
	@FindBy(xpath="//div[text()=\"Signup\"]") WebElement Signin;
	@FindBy(xpath="//div[text()=\"Login\"]") WebElement Login;
	@FindBy(xpath="//input[@data-testid=\"user-mobileno-input-box\"]") WebElement Mobile;
	@FindBy(xpath="//input[@data-testid=\"password-input-box-cta\"]") WebElement Pass;
	@FindBy(xpath="//div[@data-testid=\"login-cta\"]") WebElement LoginClick;
	
	@FindBy(xpath="//div[text()=\"one way\"]") WebElement Oneway;
	@FindBy(xpath="//div[text()=\"To\"]") WebElement Destination;
	@FindBy(xpath="//div[text()=\"Chennai\"]") WebElement City;
	@FindBy(xpath="//div[text()=\"Wed, 8 Jan 2025\"]") WebElement Calendar;
	@FindBy(xpath="(//div[text()='31'])[1]") WebElement Date;
	@FindBy(xpath="//div[@class=\"css-1dbjc4n r-1awozwy r-z2wwpe r-1loqt21 r-18u37iz r-1777fci r-1g94qm0 r-1w50u8q r-ah5dr5 r-1otgn73\"]")  WebElement Search;
	
	@FindBy(xpath="//div[text()=\"round trip\"]") WebElement Roundtrip;
	@FindBy(xpath="//input[@value=\"Select Destination\"]") WebElement RDesti;
	@FindBy(xpath="//div[text()=\"Chennai\"]") WebElement RCity;
	@FindBy(xpath="(//div[text()='31'])[2]") WebElement Returndate;
	@FindBy(xpath="//div[text()='check-in']") WebElement Checkin;
	@FindBy(xpath="(//input[@class='css-1cwyjr8 r-homxoj r-ubezar r-1eimq0t r-1e081e0 r-xfkzu9 r-lnhwgy'])[1]") WebElement PNR;
	@FindBy(xpath="//input[@placeholder='john.doe@spicejet.com']") WebElement mailid;
	@FindBy(xpath="//div[@class='css-1dbjc4n r-1awozwy r-19m6qjp r-z2wwpe r-1loqt21 r-18u37iz r-1777fci r-1w50u8q r-ah5dr5 r-1otgn73 r-13qz1uu']") WebElement Searchbooking;
	@FindBy(xpath="//div[text()='flight status']") WebElement FlightStatus;
	@FindBy(xpath="(//input[@value=\"Select Origin\"])[1]") WebElement From;
	@FindBy(xpath="//div[text()=\"Chennai\"]") WebElement FromCity;
	@FindBy(xpath="//input[@value='Select Destination']") WebElement To;
	@FindBy(xpath="//div[text()='Ahmedabad']") WebElement ToCity;
	@FindBy(xpath="//div[@class='css-1dbjc4n r-1awozwy r-19m6qjp r-z2wwpe r-1loqt21 r-18u37iz r-1777fci r-1w50u8q r-ah5dr5 r-1otgn73 r-13qz1uu']") WebElement SearchFlights;
	
	@FindBy(xpath="//div[text()=\"manage booking\"]") WebElement Managebooking;
	@FindBy(xpath="//input[@placeholder=\"john.doe@spicejet.com / Doe\"]") WebElement DOE;
 
    WebDriver driver;
    public HomepageSP(WebDriver driver) {
    	this.driver=driver;
    	PageFactory.initElements(driver, this);
    }
  
	
    public SigninSP gotoSignin() {
    	Signin.click();
    	String mainWindow = driver.getWindowHandle();
    	Set<String> allwindow=driver.getWindowHandles();
    	Iterator<String> iterator=allwindow.iterator();
    	while(iterator.hasNext()) {
    		String childWindow=iterator.next();
    	if(!mainWindow.equalsIgnoreCase(childWindow)) {
    		driver.switchTo().window(childWindow);
    	}
    	}
    	return new SigninSP(driver);
    }
    
    public void Login(String Mobilenumber, String Password) {
    	Login.click();
    	Mobile.sendKeys(Mobilenumber);
    	Pass.sendKeys(Password);
    	LoginClick.click();
    }
    
    public FlightsSP gotoFlights() {
    	Oneway.click();
    	Destination.click();
    	City.click();
    //	Calendar.click();
    	Date.click();
    	Search.click();
    	return new FlightsSP(driver);
    }
    
    public FlightsSP Roundtrip() {
    	Roundtrip.click();
    	RDesti.click();
    	RCity.click();
    	Date.click();
    	Returndate.click();
    	Search.click();
    	return new FlightsSP(driver);
    }
    
    public void CheckIn(String Pnr, String email) {
    	Checkin.click();
    	PNR.sendKeys(Pnr);
    	mailid.sendKeys(email);
    	Searchbooking.click();
    }
    
    public void FlightStatus() {
    	FlightStatus.click();
    	From.click();
    	FromCity.click();
    	//To.click();
    	ToCity.click();
    	SearchFlights.click();
    }
    
    public void Managebooking(String Ticketno, String mail) {
    	Managebooking.click();
    	PNR.sendKeys(Ticketno);
    	DOE.sendKeys(mail);
    	Searchbooking.click();
    }
}
