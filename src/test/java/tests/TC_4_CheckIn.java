package tests;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.spicebase;
import pages.HomepageSP;

public class TC_4_CheckIn extends spicebase{
	
	@BeforeTest
	public void setup() {
		TestName="Check IN";
		TestAuthor="Sundar";
		TestDescription="To validate Check in functionality in SpiceJet Website";
		sheetname="CheckIN";
	}
	
	@Test(dataProvider = "readData", priority=4)
	public void checkin(String pnr, String mail) throws IOException {
		HomepageSP Hsp=new HomepageSP(driver);
		Hsp.CheckIn(pnr, mail);
		TakeScreenshot("TC4_CheckIn");
	}

}
