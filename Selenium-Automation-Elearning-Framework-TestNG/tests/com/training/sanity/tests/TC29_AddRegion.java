package com.training.sanity.tests;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AddRegion;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TC29_AddRegion {

	private WebDriver driver;
	private String baseUrl;
	private AddRegion AddRegion;
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
		AddRegion = new AddRegion(driver); 
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
	
	public void region() throws InterruptedException {

//////////////////Admin Log in ///////////////////
		AddRegion.sendUserName("admin");
		AddRegion.sendPassword("admin@123");
		AddRegion.clickLoginBtn(); 
//////////////////Admin Log in ///////////////////
		
		
///////////////// Property Click ////////////////		
		AddRegion.propClick(); //Selects property from list
///////////////// Property Click ////////////////	
		
		
///////////////// Adding New Region ///////////		
		AddRegion.regionlinkClick();
		AddRegion.sendtagName("Silk Board");
		AddRegion.sendslug("silkboard");
		AddRegion.parentdropdown();
		AddRegion.sendregionDescr("Silk Board Junction Signal");
		
		AddRegion.clickaddnewregionBtn(); 
			
///////////////// Adding New Region ////////////
		
		
		AddRegion.scrollup();
		
///////////////// Searching for Added Region /////////////
		AddRegion.sendregionSearch("silk");
		AddRegion.clicksearchSbmBtn();
////////////////  Searching for Added Region ////////////		
	}
	
	
}

