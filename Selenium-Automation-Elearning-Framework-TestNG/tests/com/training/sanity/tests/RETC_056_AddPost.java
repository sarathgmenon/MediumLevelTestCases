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
import com.training.pom.AddPost;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_056_AddPost {

	private WebDriver driver;
	private String baseUrl;
	private AddPost AddPost;
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
		AddPost = new AddPost(driver); 
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
	
	public void realestateportal() throws InterruptedException {

//////////////////Admin Log in ///////////////////
		AddPost.sendUserName("admin");
		AddPost.sendPassword("admin@123");
		AddPost.clickLoginBtn(); 
//////////////////Admin Log in ///////////////////
		
		
///////////////// Post Click ////////////////		
		AddPost.postClick(); //Selects property from list
///////////////// Post Click ////////////////	
		
		
///////////////// Entering Values for New Post ///////////		
		AddPost.addnewClick();

		AddPost.postTitle("New Launch_Sarath");
		AddPost.postBody("New Launch in Home_Sarath");
		//AddPost.scroll();
		AddPost.categoryClick();
///////////////// Entering Values for New Post////////////
		
		
///////////////// Viewing newly created post from Dashboard ///////////////
		AddPost.dashboard();
////////////////  Viewing newly created post from Dashboard ////////////		
}
	
	
}

