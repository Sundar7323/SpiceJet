package tests;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.spicebase;
import pages.HomepageSP;

public class TC_6_Managebooking extends spicebase{
	@BeforeTest
	public void setup() {
		TestName="Flight Status";
		TestAuthor="Sundar";
		TestDescription="To validate ManageBooking functionality in SpiceJet Website";
		sheetname="ManageBooking";
	}
	@Test(dataProvider = "readData",priority=6)
	public void Managebook(String PNR, String email) throws IOException, InterruptedException {
		HomepageSP Hsp=new HomepageSP(driver);
		Hsp.Managebooking(PNR, email);
		Thread.sleep(2000);
		TakeScreenshot("TC6_ManageBooking");
	}
}
