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

import com.training.pom.AddReplyComment;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_058_AddReplyComment {

	private WebDriver driver;
	private String baseUrl;
	private AddReplyComment AddReplyComment;
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
		AddReplyComment = new AddReplyComment(driver); 
		baseUrl = properties.getProperty("baseURL");
	//	screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	

	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(30000);
	//	driver.quit();
	}
	
	@Test
	
	public void addreply() throws Exception {

//////////////////User Entering Comment ///////////////////
		AddReplyComment.blog();
		AddReplyComment.sendcommentBox("Good","Sarath Menon Test");
		AddReplyComment.sendemail("sarath1@test.com");
	//	((JavascriptExecutor) driver).executeScript("window.open(arguments[0])", baseUrl);
		Thread.sleep(3000);
//////////////////Admin Log in /////////////////////////////
		AddReplyComment.scroll();
		AddReplyComment.launchNewWindowAdminSite();
		AddReplyComment.sendUserName("admin");
		AddReplyComment.sendPassword("admin@123");
		AddReplyComment.clickLoginBtn(); 
		AddReplyComment.comments();
		AddReplyComment.clickReplyIcon();
		AddReplyComment.sendReply("Thanks");
		driver.navigate().refresh();
		System.out.println("The End");
}

	
	
	
}
