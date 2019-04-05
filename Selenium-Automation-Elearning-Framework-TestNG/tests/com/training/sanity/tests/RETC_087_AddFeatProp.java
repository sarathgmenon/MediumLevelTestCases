package com.training.sanity.tests;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import static org.testng.Assert.assertEquals;



import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.pom.AddFeatProp_RETC087;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
import com.training.bean.LoginBean;
import com.training.readexcel.ReadExcel;
import com.training.dataproviders.LoginDataProviders;

public class RETC_087_AddFeatProp {

	private WebDriver driver;
	private String baseUrl;
//	private String tName, slug, featureDescr, featureSearch, propTitle, propContent;
	private AddFeatProp_RETC087 AddFeatProp_RETC087;
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
		AddFeatProp_RETC087 = new AddFeatProp_RETC087(driver); 
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
	
	@Test(dataProvider = "excel-inputs", dataProviderClass = LoginDataProviders.class)
	
	public void addprop(String tName,String slug,String featureDescr,String featureSearch,String propTitle,String propContent) throws InterruptedException {

//////////////////Admin Log in ///////////////////
		AddFeatProp_RETC087.sendUserName("admin");
		AddFeatProp_RETC087.sendPassword("admin@123");
		AddFeatProp_RETC087.clickLoginBtn(); 
//////////////////Admin Log in ///////////////////
		
		
///////////////// Property Click ////////////////		
		AddFeatProp_RETC087.propClick(); //Selects property from list
///////////////// Property Click ////////////////	
		
		
///////////////// Adding New Feature ///////////		
		AddFeatProp_RETC087.featuresClick();
		AddFeatProp_RETC087.sendtagName(tName);
		AddFeatProp_RETC087.sendslug(slug);
		AddFeatProp_RETC087.sendfeatureDescr(featureDescr);
		
		AddFeatProp_RETC087.clickaddnewFeatBtn(); 
	//	screenShot.captureScreenShot("First");
///////////////// Adding New Feature ////////////
		
		
		AddFeatProp_RETC087.scrollup();
		
///////////////// Searching for Added Feature /////////////
		AddFeatProp_RETC087.sendfeatureSearch(featureSearch);
		AddFeatProp_RETC087.clicksearchSbmBtn();
////////////////  Searching for Added Feature ////////////		
	
	

	/////////////// Adding Property /////////////////////
		AddFeatProp_RETC087.newProp(propTitle,propContent); 
		
	////////////////Adding Property//////////////////////
}
}

