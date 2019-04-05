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
import com.training.pom.AddFeatProp_RETC088;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_088_AddFeatProp {

	private WebDriver driver;
	private String baseUrl;
	private AddFeatProp_RETC088 AddFeatProp_RETC088;
	private static Properties properties;
	//private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		AddFeatProp_RETC088 = new AddFeatProp_RETC088(driver); 
		baseUrl = properties.getProperty("baseURL");
	//	screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	

	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(30000);
		driver.quit();
	}
	
	@Test
	
	public void addprop() throws InterruptedException {

//////////////////Admin Log in ///////////////////
		AddFeatProp_RETC088.sendUserName("admin");
		AddFeatProp_RETC088.sendPassword("admin@123");
		AddFeatProp_RETC088.clickLoginBtn(); 
//////////////////Admin Log in ///////////////////
		
		
///////////////// Property Click ////////////////		
		AddFeatProp_RETC088.propClick(); //Selects property from list
///////////////// Property Click ////////////////	
		
		
///////////////// Adding New Feature ///////////		
		AddFeatProp_RETC088.featuresClick();
		AddFeatProp_RETC088.sendtagName("New Launches");
		AddFeatProp_RETC088.sendslug("launch");
		AddFeatProp_RETC088.sendfeatureDescr("New Launches of Villas, Apartments, Flats (88)");
		
		AddFeatProp_RETC088.clickaddnewFeatBtn(); 
	//	screenShot.captureScreenShot("First");
///////////////// Adding New Feature ////////////
		
		
		AddFeatProp_RETC088.scrollup();
		
///////////////// Searching for Added Feature /////////////
		AddFeatProp_RETC088.sendfeatureSearch("New Launches");
		AddFeatProp_RETC088.clicksearchSbmBtn();
////////////////  Searching for Added Feature ////////////		
	
	

	/////////////// Adding Property /////////////////////
		AddFeatProp_RETC088.newProp("Prestige"," Home Town ");
		AddFeatProp_RETC088.reSearch("Prestige");
		
	////////////////Adding Property//////////////////////
}
}

