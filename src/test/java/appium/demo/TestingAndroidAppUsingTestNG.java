package appium.demo;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Data.ExcelReader;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

@Test(priority=2,alwaysRun=true,dataProvider = "ExcelData")

public class TestingAndroidAppUsingTestNG {

	
	
	public  AndroidDriver driver;	
	
	@DataProvider(name="ExcelData")
	public static Object[][ ] UserRegisterData() throws IOException{
		
		ExcelReader ER = new ExcelReader();
		
		
		return ER.getExcelData("SignIn");
		
		
	}


	@Test(priority=2,alwaysRun=true,dataProvider = "ExcelData")
	public void DataOfApplication(String companyName , String phone , String password ) throws MalformedURLException, InterruptedException {
		File app = new File ("TaskedIn_qc1295501502971117063.apk");

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "7.1.1");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus6p");
		caps.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());


		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


		AndroidElement closeFirstWorkthrough =   driver.findElement(By.id("com.megatrust.taskedin.qc:id/close_mbtn"));

		closeFirstWorkthrough.click();
	System.out.println("first page could be closed ");
	
		
//		
//		Wait <AndroidDriver> wait = new FluentWait <AndroidDriver> (driver)
//		.pollingEvery(Duration.ofSeconds(40))
//		.ignoring(NoSuchElementException.class);
//		
		
		
		AndroidElement EmployeeBtn = driver.findElement(By.id("com.megatrust.taskedin.qc:id/employee_mbtn"));
		
//		wait.until(ExpectedConditions.elementToBeClickable(EmployeeBtn));
	EmployeeBtn.click();


	
	MobileElement  CompanyName = (MobileElement) driver.findElement(By.id("com.megatrust.taskedin.qc:id/company_name_tiet"));
	CompanyName.sendKeys(companyName);


	AndroidElement Phone = (AndroidElement) driver.findElement(By.id("com.megatrust.taskedin.qc:id/phone_tiet"));
Phone.sendKeys(phone);




AndroidElement Password = driver.findElement(By.id("com.megatrust.taskedin.qc:id/password_tiet"));
Password.sendKeys(password);

AndroidElement LoginBtn = driver.findElement(By.id("com.megatrust.taskedin.qc:id/login_mbtn"));
LoginBtn.click();

System.out.println("Employee Signed in successfully. ");


WebDriverWait wait1 = new WebDriverWait(driver,20);
driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);



AndroidElement MoreBtn = driver.findElement(By.id("com.megatrust.taskedin.qc:id/moreFragment"));
wait1.until(ExpectedConditions.visibilityOf(MoreBtn));
MoreBtn.click();

	




	
	
//AndroidElement SignOutBtn = (AndroidElement) ((FindsByAndroidUIAutomator<AndroidElement>) driver)
//    .findElementByAndroidUIAutomator("new UiScrollable("
//        + "new UiSelector().scrollable(true)).scrollIntoView("                      
//        + "new UiSelector().textContains(\"Sign Out\"));");
//SignOutBtn.click();





AndroidElement SignOutBtn = (AndroidElement) ((FindsByAndroidUIAutomator<AndroidElement>) driver)
.findElementByAndroidUIAutomator("new UiScrollable("
  + "new UiSelector().scrollable(true)).scrollIntoView("                      
  + "new UiSelector().text(\"Sign Out\"));");
SignOutBtn.click();


WebDriverWait wait = new WebDriverWait(driver,20);
WebElement  ConfirmBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.megatrust.taskedin.qc:id/confirm_mbtn")));
ConfirmBtn.click();
//
//WebElement  CancelBtn = driver.findElement(By.id("com.megatrust.taskedin.qc:id/cancel_mbtn"));
//CancelBtn.click();

System.out.println("Employee Signed out ");

	
}
}
