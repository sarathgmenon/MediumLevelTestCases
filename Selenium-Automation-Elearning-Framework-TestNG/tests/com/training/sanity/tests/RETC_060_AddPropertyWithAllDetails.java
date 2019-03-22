package com.training.sanity.tests;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.pom.AddPropertyWithAllDetails;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_060_AddPropertyWithAllDetails {

	private WebDriver driver;
	private String baseUrl;
	private AddPropertyWithAllDetails AddPropertyWithAllDetails;
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
		AddPropertyWithAllDetails = new AddPropertyWithAllDetails(driver); 
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
	
	public void addpropalldet() throws InterruptedException {

//////////////////Admin Log in ///////////////////
		AddPropertyWithAllDetails.sendUserName("admin");
		AddPropertyWithAllDetails.sendPassword("admin@123");
		AddPropertyWithAllDetails.clickLoginBtn();
	
//////////////////Admin Log in End ///////////////////
		
///////////////////Adding New Property/////////////////
	
	AddPropertyWithAllDetails.propClick();
	AddPropertyWithAllDetails.newProp("New Launch"," New Launch");
	AddPropertyWithAllDetails.price("50000.00","200.00");
	AddPropertyWithAllDetails.maindet("New","Electronic City","Immediate");
	AddPropertyWithAllDetails.locdet("Yeshwanthpur","Yeshwanthpur","120","56");
	AddPropertyWithAllDetails.details("2");
/////////////////Adding New Property End/////////////////////////	
	
}
	
}