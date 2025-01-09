package utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class Utils {

	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest Test;
	public String TestName, TestAuthor, TestDescription;
	public String sheetname;

	public void BrowserLaunch() {
		driver = new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	public void CloseBrowser() {
		driver.close();
	}

	public static String[][] readExcel(String sheetName) throws IOException {

		XSSFWorkbook book = new XSSFWorkbook("C:\\Users\\it185\\eclipse-workspace\\Spice\\Data\\ExcelData.xlsx");

		XSSFSheet sheet = book.getSheet(sheetName);

		int rowCount = sheet.getLastRowNum();

		int columnCount = sheet.getRow(0).getLastCellNum();

		String[][] data = new String[rowCount][columnCount];

		for (int i = 1; i <= rowCount; i++) {

			XSSFRow row = sheet.getRow(i);

			for (int j = 0; j < columnCount; j++) {

				XSSFCell cell = row.getCell(j);
				data[i - 1][j] = cell.getStringCellValue();
			}
		}

		book.close();
		return data;
	}

	public void TakeScreenshot(String filename) throws IOException {
		TakesScreenshot sc = (TakesScreenshot) driver;
		File src = sc.getScreenshotAs(OutputType.FILE);
		File Destination = new File("C:\\Users\\it185\\eclipse-workspace\\Spice\\Screenshots\\" + filename + ".png");
		FileUtils.copyFile(src, Destination);
	}

}
