package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.spicebase;
import pages.HomepageSP;
import pages.SigninSP;

public class TC_Signin extends spicebase{
	
	
	//DID NOT ADD THIS TEST CASE IN SUITE AS PER LEEMA MAM, AS THIS WEBSITE CONTAINS SOME ERRORS//

	@BeforeTest
	public void setup() {
		TestName="Sign-in Functionality";
		TestAuthor="Sundar";
		TestDescription="To validate the Sign-in page of the SpiceJet";
		sheetname="Signin";
	}

	@Test(dataProvider = "readData")
	public void Signin(String FirstName, String LastName, String Mobile, String EmailID, String pass, String confrimpass) throws InterruptedException {
		
		HomepageSP Hsp=new HomepageSP(driver);
		Hsp.gotoSignin();
		
		SigninSP Ssp=new SigninSP(driver);
		Ssp.Signindata(FirstName, LastName, Mobile, EmailID, pass, confrimpass);
		
	}
}
