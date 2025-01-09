package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.spicebase;
import pages.FlightStatusSP;
import pages.HomepageSP;

public class TC_5_FlightStatus extends spicebase{

	@BeforeTest
	public void setup() {
		TestName="Flight Status";
		TestAuthor="Sundar";
		TestDescription="To validate Flight Status functionality in SpiceJet Website";
	}
	@Test(priority=5)
	public void FlightStatus() throws InterruptedException, IOException {
		HomepageSP Hsp=new HomepageSP(driver);
		Hsp.FlightStatus();
		String ActualT=driver.getTitle();
		System.out.println(ActualT);
		String ExpectedT="SpiceJet - Flight Booking for Domestic and International, Cheap Air Tickets";
		Assert.assertEquals(ExpectedT, ActualT);
		Thread.sleep(2000);
		TakeScreenshot("TC5_FlightStatus");
		
		FlightStatusSP Fssp=new FlightStatusSP(driver);
		Fssp.gotoHome();
	}
}
