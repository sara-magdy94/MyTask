package appium.demo;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class CloseThirdWorkthroughPage {
	
	protected  AppiumDriver<WebElement> driver;	
	@Test
	public void openApplication() throws MalformedURLException, InterruptedException {
		File app = new File ("app\\TaskedIn_qc1295501502971117063.apk");

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "11.0");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554 (11)");
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

				WebElement closeThirdWorkthrough =   driver.findElement(By.id("com.megatrust.taskedin.qc:id/close_mbtn"));
				closeThirdWorkthrough.click();
					System.out.println("Third page could be closed ");
					
}}

