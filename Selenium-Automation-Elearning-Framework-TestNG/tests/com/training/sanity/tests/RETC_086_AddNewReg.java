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
import com.training.pom.AddNewReg_RETC086;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_086_AddNewReg {

	private WebDriver driver;
	private String baseUrl;
	private AddNewReg_RETC086 AddNewReg_RETC086;
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
		AddNewReg_RETC086 = new AddNewReg_RETC086(driver); 
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
	
	public void addnewregion() throws InterruptedException {

//////////////////Admin Log in ///////////////////
		AddNewReg_RETC086.sendUserName("admin");
		AddNewReg_RETC086.sendPassword("admin@123");
		AddNewReg_RETC086.clickLoginBtn(); 
//////////////////Admin Log in ///////////////////
		
		
///////////////// Property Click ////////////////		
		AddNewReg_RETC086.propClick(); //Selects property from list
///////////////// Property Click ////////////////	
		
		
///////////////// Adding New Region ///////////		
		AddNewReg_RETC086.regionlinkClick();
		AddNewReg_RETC086.sendtagName("New Launches");
		AddNewReg_RETC086.sendslug("launch");
		AddNewReg_RETC086.parentdropdown();
		AddNewReg_RETC086.sendregionDescr("New Launches of Villas, Apartments and Flats");
		
		AddNewReg_RETC086.clickaddnewregionBtn(); 
			
///////////////// Adding New Region ////////////
		
		
		AddNewReg_RETC086.scrollup();
		
///////////////// Searching for Added Region /////////////
		AddNewReg_RETC086.sendregionSearch("New Launches");
		AddNewReg_RETC086.clicksearchSbmBtn();
////////////////  Searching for Added Region ////////////		
	}
	
	
}

