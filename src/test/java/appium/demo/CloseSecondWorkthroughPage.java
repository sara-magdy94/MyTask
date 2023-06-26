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

public class CloseSecondWorkthroughPage {
	
	protected  AppiumDriver<WebElement> driver;	
	@Test
	public void openApplication() throws MalformedURLException, InterruptedException {
File app = new File ("D:\\New folder\\eclipse workspace\\demo\\app\\TaskedIn_qc1295501502971117063.apk");

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "7.1.1");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus6p");
		caps.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());


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
		

			WebElement closeSecondWorkthrough =   driver.findElement(By.id("com.megatrust.taskedin.qc:id/close_mbtn"));
			closeSecondWorkthrough.click();
					System.out.println("Second page could be closed ");
					
	}

}
