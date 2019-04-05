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
import com.training.pom.AddPropAllDet_RETC090;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_090_AddPropAllDet {

	private WebDriver driver;
	private String baseUrl;
	private AddPropAllDet_RETC090 AddPropAllDet_RETC090;
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
		AddPropAllDet_RETC090 = new AddPropAllDet_RETC090(driver); 
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
	
	@Test(dataProvider = "excel-inputs3", dataProviderClass = LoginDataProviders.class)
	
	public void addpropalldet(String propTitle, String propContent, String priceText, String priceSq, String status, String location, String possession, String address, String mapaddr, String latitude, String longitude, String storage) throws InterruptedException {

//////////////////Admin Log in ///////////////////
		AddPropAllDet_RETC090.sendUserName("admin");
		AddPropAllDet_RETC090.sendPassword("admin@123");
		AddPropAllDet_RETC090.clickLoginBtn();
	
//////////////////Admin Log in End ///////////////////
		
///////////////////Adding New Property/////////////////
	
		AddPropAllDet_RETC090.propClick();
		AddPropAllDet_RETC090.newProp(propTitle,propContent);
		AddPropAllDet_RETC090.price(priceText,priceSq);
		AddPropAllDet_RETC090.maindet(status,location,possession);
		AddPropAllDet_RETC090.locdet(address,mapaddr,latitude,longitude);
		AddPropAllDet_RETC090.details(storage);
/////////////////Adding New Property End/////////////////////////	
	
}
	
}