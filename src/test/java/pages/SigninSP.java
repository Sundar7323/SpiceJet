package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.spicebase;

public class SigninSP extends spicebase{
	
	@FindBy(xpath="//select[@class='form-control form-select ']") WebElement Title;
	@FindBy(id="first_name") WebElement Fname;
	@FindBy(id="last_name") WebElement Lname;
	@FindBy(id="dobDate") WebElement DOB;
	@FindBy(xpath="//select[@class=\"react-datepicker__year-select\"]") WebElement Year;
	@FindBy(xpath="//select[@class=\"react-datepicker__month-select\"]") WebElement Month;
	@FindBy(xpath="//div[@class=\"react-datepicker__day react-datepicker__day--027\"]") WebElement Date;
	@FindBy(xpath="//input[@class=' form-control']") WebElement Phone;
	@FindBy(id="email_id") WebElement Email;
	@FindBy(id="new-password") WebElement password;
	@FindBy(id="c-password") WebElement Confirmpass;
	@FindBy(id="defaultCheck1") WebElement Checkbox;
	@FindBy(xpath="//button[text()='Submit']") WebElement Submit;
	
	WebDriver driver;
	public SigninSP(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void Signindata(String fname, String lname, String phno, String mail, String pass, String conpass) throws InterruptedException {
		Title.click();
		Select drpdwn=new Select(Title);
		drpdwn.selectByVisibleText("Mr");
		Fname.sendKeys(fname);
		Lname.sendKeys(lname);
		DOB.click();
		Select drpyear=new Select(Year);
		drpyear.selectByIndex(76);
		Select drpmonth=new Select(Month);
		drpmonth.selectByVisibleText("March");
		Date.click();
		Thread.sleep(1000);
		Phone.sendKeys(phno);
		Thread.sleep(1000);
		Email.sendKeys(mail);
		password.sendKeys(pass);
		Confirmpass.sendKeys(conpass);
		Checkbox.click();
		Submit.click();
		
	}

}
