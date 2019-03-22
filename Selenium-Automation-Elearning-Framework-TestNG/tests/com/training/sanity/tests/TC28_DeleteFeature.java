package com.training.sanity.tests;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.DeleteFeature;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TC28_DeleteFeature {

	private WebDriver driver;
	private String baseUrl;
	private DeleteFeature DeleteFeature;
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
		DeleteFeature = new DeleteFeature(driver); 
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
	
	public void delfeat() throws InterruptedException {

//////////////////Admin Log in ///////////////////
		DeleteFeature.sendUserName("admin");
		DeleteFeature.sendPassword("admin@123");
		DeleteFeature.clickLoginBtn(); 
//////////////////Admin Log in ///////////////////
		
		
///////////////// Property Click ////////////////		
		DeleteFeature.propClick(); //Selects property from list
///////////////// Property Click ////////////////	
		
		
///////////////// Feature Click ///////////		
		DeleteFeature.featuresClick();
		
		DeleteFeature.selFeature();  //Selecting Feature to Delete
		screenShot.captureScreenShot("First");
///////////////// Feature Click ////////////
		
		
///////////////// Delete Function /////////////
		DeleteFeature.dropdownSelect();
		DeleteFeature.clickApplyBtn();
////////////////  Delete Function ////////////		
	}
	
	
}

