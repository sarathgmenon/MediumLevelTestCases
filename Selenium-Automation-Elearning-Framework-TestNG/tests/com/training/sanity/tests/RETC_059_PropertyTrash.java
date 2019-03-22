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
import com.training.pom.PropertyTrash;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_059_PropertyTrash {

	private WebDriver driver;
	private String baseUrl;
	private PropertyTrash PropertyTrash;
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
		PropertyTrash = new PropertyTrash(driver); 
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
	
	public void proptrash() throws Exception {

//////////////////Admin Log in /////////////////////////////
		
		PropertyTrash.sendUserName("admin");
		PropertyTrash.sendPassword("admin@123");
		PropertyTrash.clickLoginBtn(); 
		PropertyTrash.propClick();
		PropertyTrash.propValue("Brigade");
		PropertyTrash.propValue2("Gateway");
		PropertyTrash.checkbox();
	}	

}