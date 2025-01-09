package tests;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.spicebase;
import pages.HomepageSP;

public class TC_1_LoginTest extends spicebase{
	
	@BeforeTest
	public void setup() {
		TestName="Login";
		TestAuthor="Sundar";
		TestDescription="To validate the Login functionality in SpiceJet Website";
		sheetname="Login";
	}
	
	@Test(dataProvider = "readData", priority=1)
	public void logintest(String MobileNumber, String Psw) throws IOException {
		HomepageSP Hsp=new HomepageSP(driver);
		Hsp.Login(MobileNumber, Psw);
		
		TakeScreenshot("TC1_Login");
	}

}
