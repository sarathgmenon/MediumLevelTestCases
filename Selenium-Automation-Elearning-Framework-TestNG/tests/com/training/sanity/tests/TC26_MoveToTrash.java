package com.training.sanity.tests;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.RealEstate_PropCheck;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TC26_MoveToTrash {

	private WebDriver driver;
	private String baseUrl;
	private RealEstate_PropCheck RealEstate_PropCheck;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		RealEstate_PropCheck = new RealEstate_PropCheck(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(30000);
		driver.quit();
	}
	@Test
	public void movetrashtest() throws InterruptedException {
		RealEstate_PropCheck.sendUserName("admin");
		RealEstate_PropCheck.sendPassword("admin@123");
		RealEstate_PropCheck.clickLoginBtn(); 
		RealEstate_PropCheck.propClick(); //Selects property from list
		
		RealEstate_PropCheck.dropdownSelect();
		RealEstate_PropCheck.clickApplyBtn(); 
		screenShot.captureScreenShot("First");
	
	}
	
	//@Test
	//public void PropertyCheck() {
	//	RealEstateProperty.clickProperty();
		
		
	//}
}
