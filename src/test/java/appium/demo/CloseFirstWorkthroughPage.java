package appium.demo;

import java.io.File;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class CloseFirstWorkthroughPage {
	
	
	protected  AppiumDriver<WebElement> driver;	
	protected FileInputStream inputStream;
	protected Properties prop;
	
	
	@Parameters({"deviceName", "platformName" , "platformVersion"})
	@Test
	public void beforeClass(String deviceName , String platformName , String platformVersion ) throws Exception {
		
		
		
		
		File propFile = new File ("src/test/resources/config/config.properties");
		inputStream = new FileInputStream(propFile);
		prop = new Properties();
		prop.load(inputStream);
		
		File androidApp = new File(prop.getProperty("androidAppPath"));

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("platformName", platformName);
		caps.setCapability("platformVersion", platformVersion);
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
		caps.setCapability(MobileCapabilityType.APP, androidApp.getAbsolutePath());
		//caps.setCapability("browserName", "Chrome"); //incase of web
		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL(prop.getProperty("appiumServerLink")), caps);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


		WebElement TextinFirstWorkthrough =   driver.findElement(By.xpath("//*[contains(@text,'Check tasks progress at any given time and anywhere through the app.')]"));
		String Text1 = TextinFirstWorkthrough.getText();
		System.out.println("first page text is : "+ Text1);
		Assert.assertEquals("Check tasks progress at any given time and anywhere through the app.", Text1);

			
			WebElement closeFirstWorkthrough =   driver.findElement(By.id("com.megatrust.taskedin.qc:id/close_mbtn"));
			closeFirstWorkthrough.click();
		System.out.println("first page could be closed ");
		
	}
	
	
	
	
	
	
	//@Test
//	public void openApplication() throws MalformedURLException, InterruptedException {

		

	//}
}
