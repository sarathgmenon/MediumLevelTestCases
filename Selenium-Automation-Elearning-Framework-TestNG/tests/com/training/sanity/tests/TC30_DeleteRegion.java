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
import com.training.pom.DeleteRegion;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TC30_DeleteRegion {

	private WebDriver driver;
	private String baseUrl;
	private DeleteRegion DeleteRegion;
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
		DeleteRegion = new DeleteRegion(driver); 
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
	
	public void delreg() throws InterruptedException {

//////////////////Admin Log in ///////////////////
		DeleteRegion.sendUserName("admin");
		DeleteRegion.sendPassword("admin@123");
		DeleteRegion.clickLoginBtn(); 
//////////////////Admin Log in ///////////////////
		
		
///////////////// Property Click ////////////////		
		DeleteRegion.propClick(); //Selects property from list
///////////////// Property Click ////////////////	
		
		
///////////////// Region Click ///////////		
		DeleteRegion.RegionsClick();
		
		DeleteRegion.selRegion();  //Selecting Region to Delete
		screenShot.captureScreenShot("First");
///////////////// Region Click ////////////
		
		
///////////////// Delete Function /////////////
		DeleteRegion.dropdownSelect();
		DeleteRegion.clickApplyBtn();
////////////////  Delete Function ////////////		
	}
	
	
}

