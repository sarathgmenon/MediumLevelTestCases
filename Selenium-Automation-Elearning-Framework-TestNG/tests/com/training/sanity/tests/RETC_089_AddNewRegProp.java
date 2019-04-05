package com.training.sanity.tests;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.AddNewRegProp_RETC089;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_089_AddNewRegProp {

	private WebDriver driver;
	private String baseUrl;
	private AddNewRegProp_RETC089 AddNewRegProp_RETC089;
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
		AddNewRegProp_RETC089 = new AddNewRegProp_RETC089(driver); 
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
@Test(dataProvider = "excel-inputs2", dataProviderClass = LoginDataProviders.class)
	
	public void addregprop(String tagName,String slug,String regionDescr,String propTitle,String propContent) throws InterruptedException {

//////////////////Admin Log in ///////////////////
		AddNewRegProp_RETC089.sendUserName("admin");
		AddNewRegProp_RETC089.sendPassword("admin@123");
		AddNewRegProp_RETC089.clickLoginBtn(); 
//////////////////Admin Log in ///////////////////
		
		
///////////////// Property Click ////////////////		
		AddNewRegProp_RETC089.propClick(); //Selects property from list
///////////////// Property Click ////////////////	
		
		
///////////////// Adding New Region ///////////		
		AddNewRegProp_RETC089.regionlinkClick();
		AddNewRegProp_RETC089.sendtagName(tagName);
		AddNewRegProp_RETC089.sendslug(slug);
		AddNewRegProp_RETC089.parentdropdown();
		AddNewRegProp_RETC089.sendregionDescr(regionDescr);
		AddNewRegProp_RETC089.clickaddnewregionBtn(); 
			
///////////////// Adding New Region ////////////
		
		
	//	AddNewRegProp_RETC089.scrollup();
		

	

/////////////// Adding Property /////////////////////
		AddNewRegProp_RETC089.newProp(propTitle,propContent); 
	
////////////////Adding Property//////////////////////
	
	
	
	}
	
	
}

