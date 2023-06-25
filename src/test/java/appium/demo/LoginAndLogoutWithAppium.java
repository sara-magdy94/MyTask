package appium.demo;

import static org.testng.Assert.assertEquals;

import static org.testng.Assert.assertTrue;


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.tools.ant.types.spi.Service;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Data.ExcelReader;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileBy.ByAndroidUIAutomator;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import io.appium.java_client.touch.offset.PointOption;

public class LoginAndLogoutWithAppium {
	protected  AppiumDriver<WebElement> driver;	
	
@DataProvider(name="ExcelData")
public static Object[][ ] UserRegisterData() throws IOException{	
	
	
	ExcelReader ER = new ExcelReader();
	
	
//	
return ER.getExcelData("SignIn");
//	
}
	@Test(priority=2,alwaysRun=true,dataProvider = "ExcelData")
	public void openApplication() throws MalformedURLException, InterruptedException {
////		
////		AppiumDriverLocalService service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder().usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
////				.withAppiumJS(new File("C:\\Users\\LAPTOP\\AppData\\Local\\Programs\\Appium\\resources\\app\\node_modules\\appium\\build\\lib\\main.js")).withLogFile(new File (System.getProperty("user.dir")+"src\\test\\resources\\log.txt")).withArgument(GeneralServerFlag.LOCAL_TIMEZONE));
////		
////		service.start();
	
		
		File app = new File ("D:\\New folder\\eclipse workspace\\demo\\app\\TaskedIn_qc1295501502971117063.apk");

	DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("platformName", "Android");
	caps.setCapability("platformVersion", "7.1.1");		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus6p");
//		caps.setCapability(SystemPortcapability.SYSTEM_PORT,"XXXX");
  caps.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
////		//incase we don't have apk for app
	//caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.megatrust.taskedin.presentation.screens.onboarding.OnBoardingActivity}");
//caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.megatrust.taskedin.qc");
		//caps.setCapability("browserName", "Chrome"); //incase of web


		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//adb shell cmd appops set <com.megatrust.taskedin.qc> RUN_IN_BACKGROUND allow

		WebElement TextinFirstWorkthrough =   driver.findElement(By.xpath("//*[contains(@text,'Check tasks progress at any given time and anywhere through the app.')]"));
		String Text1 = TextinFirstWorkthrough.getText();
		System.out.println("first page text is : "+ Text1);
		Assert.assertEquals("Check tasks progress at any given time and anywhere through the app.", Text1);
		
	WebElement NextPage = driver.findElement(By.id("com.megatrust.taskedin.qc:id/next_mbtn"));
		NextPage.click();


	AndroidElement TextinSecondWorkthrough =   driver.findElement(MobileBy.xpath("//*[contains(@text,'Can quickly and easily chat with your team')]"));
		String Text2 = TextinSecondWorkthrough.getText();
		Assert.assertEquals(Text2,"Can quickly and easily chat with your team");
	System.out.println("second page text is : "+Text2);

	WebElement NextPage2 = driver.findElement(By.id("com.megatrust.taskedin.qc:id/next_mbtn"));
	NextPage2.click();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);



	WebElement TextinThirdWorkthrough =   driver.findElement(MobileBy.xpath("//*[contains(@text,'reports for your tasks and team, so you can better identify obstacles and see progress over time.')]"));
	String Text3 = TextinThirdWorkthrough.getText();
		System.out.println("third page text is : " +Text3);
	Assert.assertEquals(Text3,"reports for your tasks and team, so you can better identify obstacles and see progress over time.");

	

		AndroidElement StartBtn = (AndroidElement) driver.findElement(MobileBy.AccessibilityId("com.megatrust.taskedin.qc:id/start_mbtn"));
		StartBtn.click();

	}
	@Test(priority=1,alwaysRun=true,dataProvider = "ExcelData")
	public void DataOfApplication(String companyName , String phone , String password ) throws MalformedURLException, InterruptedException {
	
//	"TaskedIn_qc1295501502971117063.apk"
	File app = new File ("D:\\New folder\\eclipse workspace\\demo\\app\\TaskedIn_qc1295501502971117063.apk");

//		String FilePath = System.getProperty("user.dir")+ "/src/test/java/app/TaskedIn_qc1295501502971117063.apk";
//	
//		File app = new File (FilePath);
//		
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
	

		AndroidElement EmployeeBtn = driver.findElement(By.id("com.megatrust.taskedin.qc:id/employee_mbtn"));

//WebDriverWait wait = new WebDriverWait(driver,30);	
//	WebElement EmployeeBtn =wait.until(ExpectedConditions.elementToBeClickable(By.id("com.megatrust.taskedin.qc:id/employee_mbtn")));
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


//WebDriverWait wait1 = new WebDriverWait(driver,20);
//driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);



AndroidElement MoreBtn = driver.findElement(By.id("com.megatrust.taskedin.qc:id/moreFragment"));
//wait1.until(ExpectedConditions.visibilityOf(MoreBtn));
MoreBtn.click();


//
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



//TouchActions action = new TouchActions(driver);
//action.scroll(SignOutBtn, 1440, 2560);
//action.perform();


WebElement  ConfirmBtn = driver.findElement(By.id("com.megatrust.taskedin.qc:id/confirm_mbtn"));
ConfirmBtn.click();
//
//WebElement  CancelBtn = driver.findElement(By.id("com.megatrust.taskedin.qc:id/cancel_mbtn"));
//CancelBtn.click();

System.out.println("Employee Signed out ");


//driver.quit();

//service.stop();





//BeforeSuit>> BeforeTest>> BeforeClass>> BeforeMethod>> TestCase 1 >>AfterMethod>>BEforeMethod>> Test Case 2>>> AfterMethod>>AfterClas>> AfterTest>>AfterSuit 


//
//MobileElement SignOutBtn = (MobileElement) driver.findElement(ByAndroidUIAutomator("new UiScrollable(newUiSelector()).scrollIntoView(text("com.megatrust.taskedin.qc:id/sign_out_slc"))")	dfxz;
////TouchAction action = new TouchAction(driver);
//action.press(startX, startY).moveTo((endX - startX), (endY-startY)).release().perform();





//driver.pressKey(new KeyEvent(AndroidKey.Q));
//driver.pressKey(new KeyEvent(AndroidKey.U));
//driver.pressKey(new KeyEvent(AndroidKey.A));
//driver.pressKey(new KeyEvent(AndroidKey.L));
//driver.pressKey(new KeyEvent(AndroidKey.I));
//driver.pressKey(new KeyEvent(AndroidKey.T));
//driver.pressKey(new KeyEvent(AndroidKey.Y));
//	driver.pressKey(new KeyEvent(AndroidKey.1));
//	driver.pressKey(new KeyEvent(AndroidKey.U));
//	driver.pressKey(new KeyEvent(AndroidKey.A));
//	driver.pressKey(new KeyEvent(AndroidKey.L));
//	driver.pressKey(new KeyEvent(AndroidKey.I));
//	driver.pressKey(new KeyEvent(AndroidKey.T));
//	driver.pressKey(new KeyEvent(AndroidKey.Y));
////	

		//
		//	WebElement  TextinThirdWorkthrough = driver.findElement(By.id("63620d3c-afe0-442f-92f6-20480e28f167"));
		////	assertTrue(TextinThirdWorkthrough.getText().contains("reports for your tasks and team, so you can better identify obstacles and see progress over time."));
		//	Assert.assertEquals(TextinThirdWorkthrough.getText(),"reports for your tasks and team, so you can better identify obstacles and see progress over time.");
		////		
		////

		//
		////assertTrue(TextinSecondWorkthrough.getText().contains("Can quickly and easily chat with your team"));
		//	Assert.assertEquals(TextinSecondWorkthrough.getText(),"Can quickly and easily chat with your team");
		//
		//WebDriverWait wait = new WebDriverWait(driver,20);



		//		JavascriptExecutor js = (JavascriptExecutor)driver;
		//		Actions ac = new Actions(driver);
		//		ac.moveToElement(closeFirstWorkthrough).build().perform();
		//		boolean close1 = TextinFirstWorkthrough.isSelected();
		//		Assert.assertEquals(true,close1 );

		//com.megatrust.taskedin.qc:id/close_mbtn

		//*[contains(@text, ‘display text’)]
		//		Assert.assertTrue(ValidationText.getText().contains("Check tasks progress at any given time and anywhere through the app."));





	}

	//	@Test
	//	public void verifyElement(){
	//		  WebDriver driver;
	//		
	//
	//		WebElement TextinFirstWorkthrough =   driver.findElement(By.id("d042402b-0e2a-4bd8-a44e-8b7036f61f69"));
	//	Assert.assertEquals(true, TextinFirstWorkthrough.isDisplayed());
	//	
	//	 
	//	}
	//		
//deviceName: emulator-5554, deviceScreenDensity: 560, deviceScreenSize: 1440x2560


}

//
//String bodyText = driver.findElement(By.tagName("body")).getText();
//Assert.assertTrue("Text not found!", bodyText.contains(text));
//first next page id com.megatrust.taskedin.qc:id/next_mbtn

//close btn id =com.megatrust.taskedin.qc:id/close_mbtn
//747007aa-e65f-408f-9c79-cf110363fda3
// com.megatrust.taskedin.qc:id/action_bar_root


