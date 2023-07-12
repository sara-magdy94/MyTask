package appium.demo;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Data.ExcelReaderForSignUp;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class SignUpAsEmployeeWithCompany {

	protected  AppiumDriver<WebElement> driver;	
	
	@DataProvider(name="SignUpData")
	public Object[][ ] UserRegisterData() throws IOException{
		
		ExcelReaderForSignUp ER = new ExcelReaderForSignUp();
		
		
		return ER.getExcelData("Sheet1");
	
		
	}

	@Test(priority=1,alwaysRun=true,dataProvider = "SignUpData")
	public void DataOfApplication(String companyNameBtn,String chooseCompanyNameBtn , String fullNameAdminBtn ,String JobTitleBtn , String PhoneBtn2 , String rePhoneBtn2  , String Email , String Passwd , String Re_passwd ,String Re_passwd2) throws MalformedURLException, InterruptedException {
	
		File app = new File ("app\\TaskedIn_qc1295501502971117063.apk");
//	File app = new File ("TaskedIn_qc1295501502971117063.apk");

		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "11.0");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554 (11)");
		caps.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);




		WebElement TextinFirstWorkthrough =   driver.findElement(By.xpath("//*[contains(@text,'Check tasks progress at any given time and anywhere through the app.')]"));
		String Text1 = TextinFirstWorkthrough.getText();
		System.out.println("first page text is : "+ Text1);
		Assert.assertEquals("Check tasks progress at any given time and anywhere through the app.", Text1);

		

		WebElement NextPage = driver.findElement(By.id("com.megatrust.taskedin.qc:id/next_mbtn"));
		NextPage.click();


		WebElement TextinSecondWorkthrough =   driver.findElement(MobileBy.xpath("//*[contains(@text,'Can quickly and easily chat with your team')]"));
		String Text2 = TextinSecondWorkthrough.getText();
		Assert.assertEquals(Text2,"Can quickly and easily chat with your team");
		System.out.println("second page text is : "+Text2);
		

		

		WebElement NextPage2 = driver.findElement(By.id("com.megatrust.taskedin.qc:id/next_mbtn"));
		NextPage2.click();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);



		WebElement TextinThirdWorkthrough =   driver.findElement(MobileBy.xpath("//*[contains(@text,'reports for your tasks and team, so you can better identify obstacles and see progress over time.')]"));
		String Text3 = TextinThirdWorkthrough.getText();
		Assert.assertEquals(Text3,"reports for your tasks and team, so you can better identify obstacles and see progress over time.");
		System.out.println("third page text is : " +Text3);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		WebElement StartBtn = driver.findElement(By.id("com.megatrust.taskedin.qc:id/start_mbtn"));
		StartBtn.click();
		
//		WebElement closeFirstWorkthrough =   driver.findElement(By.id("com.megatrust.taskedin.qc:id/close_mbtn"));
//		closeFirstWorkthrough.click();
//		
//	System.out.println("first page could be closed ");
		
//WebDriverWait wait1 = new WebDriverWait(driver,20);



Wait<WebDriver> wait3 = new FluentWait<WebDriver>(driver)							
		.withTimeout(30, TimeUnit.SECONDS) 			
		.pollingEvery(5, TimeUnit.SECONDS) 			
		.ignoring(NoSuchElementException.class);

	AndroidElement SignUpBtn = driver.findElement(By.id("com.megatrust.taskedin.qc:id/sign_up_mbtn"));
//	wait1.until(ExpectedConditions.elementToBeSelected(SignUpBtn));
		SignUpBtn.click();
		
		// check Sign up cancel btn
//		WebElement SignUpCancelBtn = driver.findElement(By.id("com.megatrust.taskedin.qc:id/cancel_mbtn"));
//		SignUpCancelBtn.click();
		
//	AndroidElement EmployeeBtn = driver.findElement(By.id("com.megatrust.taskedin.qc:id/employee_mbtn"));

		AndroidElement SignUpCompanyBtn = driver.findElement(By.id("com.megatrust.taskedin.qc:id/company_mbtn"));
		SignUpCompanyBtn.click();
		
		
		// Company informaion

		WebElement CompanyNameBtn = driver.findElement(By.id("com.megatrust.taskedin.qc:id/company_name_tiet"));
		CompanyNameBtn.sendKeys(companyNameBtn);


		WebElement  Contry = driver.findElement(By.id("com.megatrust.taskedin.qc:id/country_section"));
		Contry.click();
		
		WebElement ChooseCompanyNameBtn = driver.findElement(By.id("com.megatrust.taskedin.qc:id/searchEt"));
		ChooseCompanyNameBtn.sendKeys(chooseCompanyNameBtn);

		
		WebElement  SelectedContry = driver.findElement(By.id("com.megatrust.taskedin.qc:id/countryNameTv"));
		SelectedContry.click();
		
		


		WebElement CompanyField = driver.findElement(By.id("com.megatrust.taskedin.qc:id/field_section"));
		CompanyField.click();
		

		WebElement SoftWareCompanyField = driver.findElement(By.id("com.megatrust.taskedin.qc:id/companyFieldMCb"));
		SoftWareCompanyField.click();


		WebElement Done = driver.findElement(By.id("com.megatrust.taskedin.qc:id/saveSelectedFieldsBtn"));
		Done.click();
		

		WebElement NumOfEmployees = driver.findElement(By.id("com.megatrust.taskedin.qc:id/no_employee_section"));
		NumOfEmployees.click();
		
		

		WebElement ChangeNumOfEmployees = driver.findElement(By.xpath("//*[contains(@text,'51-200 employees')]"));
		ChangeNumOfEmployees.click();
	

		MobileElement FullNameAdminBtn = (MobileElement) driver
			    .findElementByAndroidUIAutomator("new UiScrollable("
			        + "new UiSelector().scrollable(true)).scrollIntoView("                      
			        + "new UiSelector().textContains(\"Full Name *\"));");
		FullNameAdminBtn.sendKeys(fullNameAdminBtn);
		
		
		WebElement jobTitleBtn = driver.findElement(By.id("com.megatrust.taskedin.qc:id/job_title_tiet"));
		jobTitleBtn.sendKeys(JobTitleBtn);
		
		WebElement phoneBtn2 = driver.findElement(By.id("com.megatrust.taskedin.qc:id/phone_tiet"));
		phoneBtn2.sendKeys(PhoneBtn2);
		

		WebElement RePhoneBtn2 = driver.findElement(By.xpath("//*[contains(@text, 'Re-Phone *')]"));
		RePhoneBtn2.sendKeys(rePhoneBtn2);

	WebElement email = driver.findElement(By.id("com.megatrust.taskedin.qc:id/email_tiet"));
		email.sendKeys(Email);
		
		WebElement passwd = driver.findElement(By.id("com.megatrust.taskedin.qc:id/password_tiet"));
	passwd.sendKeys(Passwd);

		
		MobileElement re_passwd = (MobileElement) driver
			    .findElementByAndroidUIAutomator("new UiScrollable("
			        + "new UiSelector().scrollable(true)).scrollIntoView("                      
			        + "new UiSelector().text(\"Re-Password *\"));");
		passwd.sendKeys(Re_passwd);
		
		WebElement re_passwd2 = driver.findElement(By.id("com.megatrust.taskedin.qc:id/re_password_tiet"));
		re_passwd2.sendKeys(Re_passwd2);

		
		MobileElement TermsAndConditionBtn = (MobileElement) driver
			    .findElementByAndroidUIAutomator("new UiScrollable("
			        + "new UiSelector().scrollable(true)).scrollIntoView("                      
			        + "new UiSelector().textContains(\"I have read and agreed to The Terms.\"));");
		TermsAndConditionBtn.click();
		
		
		

		WebElement CreateAccountBtn = driver.findElement(By.id("com.megatrust.taskedin.qc:id/create_account_mbtn"));
		CreateAccountBtn.click();
	




driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);


WebElement MoreBtn = driver.findElement(By.id("com.megatrust.taskedin.qc:id/moreFragment"));
MoreBtn.click();



MobileElement SignOutBtn = (MobileElement) driver
    .findElementByAndroidUIAutomator("new UiScrollable("
        + "new UiSelector().scrollable(true)).scrollIntoView("                      
        + "new UiSelector().textContains(\"Sign Out\"));");
SignOutBtn.click();



WebDriverWait wait2 = new WebDriverWait(driver,20);
WebElement  ConfirmBtn = wait2.until(ExpectedConditions.elementToBeClickable(By.id("com.megatrust.taskedin.qc:id/confirm_mbtn")));
ConfirmBtn.click();
//
//WebElement  CancelBtn = driver.findElement(By.id("com.megatrust.taskedin.qc:id/cancel_mbtn"));
//CancelBtn.click();

System.out.println("Employee Signed out ");



	}
}
