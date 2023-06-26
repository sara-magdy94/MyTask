package appium.demo;

import java.awt.List;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class SignUpAsEmployeeWithUserWithoutCodeManger {

	protected  AppiumDriver<WebElement> driver;	
	@Test
	public void SignUpAsUser() throws MalformedURLException, InterruptedException {
		
//		AppiumDriverLocalService service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder().usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
//				.withAppiumJS(new File("C:\\Users\\LAPTOP\\AppData\\Local\\Programs\\Appium\\resources\\app\\node_modules\\appium\\build\\lib\\main.js"))
//				.withLogFile(new File (System.getProperty("user.dir")+"src\\test\\resources\\log.txt"))
//				.withArgument(GeneralServerFlag.LOCAL_TIMEZONE));
//		
//		service.start();
		
File app = new File ("D:\\New folder\\eclipse workspace\\demo\\app\\TaskedIn_qc1295501502971117063.apk");

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "7.1.1");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus6p");
		caps.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		//caps.setCapability("browserName", "Chrome"); //incase of web

		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);



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
		System.out.println("third page text is : " +Text3);
		Assert.assertEquals(Text3,"reports for your tasks and team, so you can better identify obstacles and see progress over time.");


		WebElement StartBtn = driver.findElement(By.id("com.megatrust.taskedin.qc:id/start_mbtn"));
		StartBtn.click();

		
//		MobileElement SignUpBtn = (MobileElement) driver
//			    .findElementByAndroidUIAutomator("new UiScrollable("			        + "new UiSelector().scrollable(true)).scrollIntoView("                      
//		        + "new UiSelector().textContains(\"SIGNUP\"));");
//		SignUpBtn.click();
//		


		WebElement SignUpBtn = driver.findElement(By.id("com.megatrust.taskedin.qc:id/sign_up_mbtn"));
		SignUpBtn.click();
		
		

		WebElement userBtn = driver.findElement(By.id("com.megatrust.taskedin.qc:id/user_mbtn"));
		userBtn.click();
		

		
		WebElement DontHaveMangerBtn = driver.findElement(By.id("com.megatrust.taskedin.qc:id/anonymous_mrbtn"));
		DontHaveMangerBtn.click();

		
		
		WebElement NextBtn = driver.findElement(By.id("com.megatrust.taskedin.qc:id/next_mbtn"));
		NextBtn.click();

		WebElement FullNameBtn = driver.findElement(By.id("com.megatrust.taskedin.qc:id/full_name_tiet"));
		FullNameBtn.sendKeys("SaraMagdy1111");
		
		WebElement jobTiltleBtn = driver.findElement(By.id("com.megatrust.taskedin.qc:id/job_title_tiet"));
		jobTiltleBtn.sendKeys("Quality");
		
		
		WebElement PhoneBtn = driver.findElement(By.id("com.megatrust.taskedin.qc:id/phone_tiet"));
		PhoneBtn.sendKeys("01005278901");
		
		WebElement RePhoneBtn = driver.findElement(By.xpath("//*[contains(@text, 'Re-Phone *')]"));
		RePhoneBtn.sendKeys("01005278901");
		
		WebElement email = driver.findElement(By.id("com.megatrust.taskedin.qc:id/email_tiet"));
		email.sendKeys("sara6776578888@gmail.com");
		
		WebElement password = driver.findElement(By.id("com.megatrust.taskedin.qc:id/password_tiet"));
		password.sendKeys("1234567");
		
		WebElement re_password = driver.findElement(By.id("com.megatrust.taskedin.qc:id/re_password_tiet"));
		re_password.sendKeys("1234567");
		
		
		
		
		MobileElement TermsAndConditionBtn = (MobileElement) driver
			    .findElementByAndroidUIAutomator("new UiScrollable("
			        + "new UiSelector().scrollable(true)).scrollIntoView("                      
			        + "new UiSelector().textContains(\"I have read and agreed to The Terms.\"));");
		TermsAndConditionBtn.click();
		
		
		WebElement CreateAccountBtn = driver.findElement(By.id("com.megatrust.taskedin.qc:id/create_account_mbtn"));
		CreateAccountBtn.click();

		//System.out.println("you Have signed Up successfully sara " );

		
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);



//driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

//WebElement MoreBtn = driver.findElement(MobileBy.AndroidUIAutomator("Description(\"More option\")"));
//android.widget.ImageView[@content-desc="More options"]
//WebElement MoreBtn = driver.findElement(By.xpath("android.widget.ImageView[@content-desc=\"More options\"]"));
WebElement MoreBtn = driver.findElement(By.id("More options"));
MoreBtn.click();

WebDriverWait wait = new WebDriverWait(driver,40);

MobileElement SignOutBtn = (MobileElement) driver
    .findElementByAndroidUIAutomator("new UiScrollable("
        + "new UiSelector().scrollable(true)).scrollIntoView("                      
        + "new UiSelector().textContains(\"Sign Out\"));");
SignOutBtn.click();




WebElement  ConfirmBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.megatrust.taskedin.qc:id/confirm_mbtn")));
ConfirmBtn.click();
//
//WebElement  CancelBtn = driver.findElement(By.id("com.megatrust.taskedin.qc:id/cancel_mbtn"));
//CancelBtn.click();

System.out.println("Employee Signed out ");


		
		
		
		
//		List <MobileElements>  mobileElements = (MobileElement) driver.findElementsByClassName("android.widget.FrameLayout");
//		
//	MobileElement mobileElement = mobileElement.get(1);
		

	}
}
