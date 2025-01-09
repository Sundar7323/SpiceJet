package base;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utils.Utils;

public class spicebase extends Utils{

	@BeforeSuite
	public void reports() {
		String path="C:\\Users\\it185\\eclipse-workspace\\Spice\\Reports";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("SpiceJet Test Report");
		extent=new ExtentReports();
		extent.attachReporter(reporter);
	}
	
	@BeforeClass
	public void testDetails() {
		Test=extent.createTest(TestName,TestDescription);
		Test.assignAuthor(TestAuthor);
	}
	
	@BeforeMethod
	public void Launch_browser() {
		BrowserLaunch();
	}
	
	@DataProvider(name = "readData")
	public String[][] readData() throws IOException {
		
	   String[][]  data = readExcel(sheetname);
	  return data;
	}
	
	@AfterMethod
	public void Close_Browser() {
		CloseBrowser();
	}
	
	@AfterSuite
	public void reportclose() {
		extent.flush();
	}
}
