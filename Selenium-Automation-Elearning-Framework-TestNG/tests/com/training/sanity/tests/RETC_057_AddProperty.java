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
import com.training.pom.AddProperty;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_057_AddProperty {

	private WebDriver driver;
	private String baseUrl;
	private AddProperty AddProperty;
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
		AddProperty = new AddProperty(driver); 
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
		AddProperty.sendUserName("admin");
		AddProperty.sendPassword("admin@123");
		AddProperty.clickLoginBtn(); 
//////////////////Admin Log in ///////////////////
		
		
///////////////// Property Click ////////////////		
		AddProperty.propClick(); //Selects property from list
///////////////// Property Click ////////////////	
		
		
///////////////// Adding New Feature ///////////		
		AddProperty.featuresClick();
		AddProperty.sendtagName("Shantiniketan");
		AddProperty.sendslug("Prestige_57");
		AddProperty.sendfeatureDescr("New Launches of Apartments");
		
		AddProperty.clickaddnewFeatBtn(); 
	//	screenShot.captureScreenShot("First");
///////////////// Adding New Feature ////////////
		
		
		AddProperty.scrollup();
		
///////////////// Searching for Added Feature /////////////
		AddProperty.sendfeatureSearch("Prestige_57");
		AddProperty.clicksearchSbmBtn();
////////////////  Searching for Added Feature ////////////		
	
	

	/////////////// Adding Property /////////////////////
			AddProperty.newProp("Prestige"," Home Town ");
		
	////////////////Adding Property//////////////////////
}
}

