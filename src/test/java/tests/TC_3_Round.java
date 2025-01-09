package tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.spicebase;
import pages.AddonSP;
import pages.FlightsSP;
import pages.HomepageSP;
import pages.PassengersSP;
import pages.PaymentSP;
import pages.PaymentfailureSP;

public class TC_3_Round extends spicebase{
	
	@BeforeTest
	public void setup() {
		TestName="Round Trip";
		TestAuthor="Sundar";
		TestDescription="To validate RoundTrip in SpiceJet Website";
		sheetname="Passengers";
	}
	
	@Test(dataProvider = "readData", priority=3)
	public void Roundtrip(String firstname, String lastname, String phone, String email, String city) throws InterruptedException, IOException {
		HomepageSP Hsp=new HomepageSP(driver);
		Hsp.Roundtrip();
		
		FlightsSP Fsp=new FlightsSP(driver);
		Fsp.SelFlight();
		
		PassengersSP Psp=new PassengersSP(driver);
		Psp.Pdetails(firstname, lastname, phone, email, city);
		
		AddonSP Asp= new AddonSP(driver);
		Asp.Addons();
		
		PaymentSP Paysp=new PaymentSP(driver);
		Paysp.payment();
		
		 String ExceptedText="Payment Failure";
			WebElement Text=driver.findElement(By.xpath("//div[@class='css-76zvg2 r-poiln3 r-1b6yd1w']"));
			String ActualText=Text.getText();
			System.out.println(ActualText);
			Assert.assertEquals(ActualText, ExceptedText);
			
			TakeScreenshot("TC3_Roundtrip");
		
		PaymentfailureSP PFsp=new PaymentfailureSP(driver);
		PFsp.gotoHome();
		
		Thread.sleep(2000);
	}
	

}
