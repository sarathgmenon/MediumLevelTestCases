package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AddPost {
	private WebDriver driver; 



	public AddPost(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
//	JavascriptExecutor jse = (JavaScriptExecutor)driver;	
//	jse.executeScript("window.scroll")

	// Finding User Id
	@FindBy(id="user_login")
	private WebElement userName; 
	
	// Finding Password
	@FindBy(id="user_pass")
	private WebElement password;
	
	//Finding  Login Button
	@FindBy(name="login")
	private WebElement loginBtn; 
	
	//Finding Post Title
	@FindBy(id="title")
	private WebElement postTitle;
	
		//Finding Post Body 
	@FindBy(id="tinymce")
	private WebElement postBody;
	
	//Finding Category
	@FindBy(id="in-category-185")
	private WebElement categorySel;
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName); //User Id Input
	}

	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); //Password Input
	}

	public void clickLoginBtn() {
		this.loginBtn.click(); //Clicking on Login button
	}

	//Clicking on Posts Link 
	public void postClick() throws InterruptedException {
		driver.findElement(By.linkText("Posts")).click(); //Click Properties Link
		Thread.sleep(3000);
		
	}
	
	//Clicking on Add New Link 
		public void addnewClick() throws InterruptedException {
			driver.findElement(By.linkText("Add New")).click(); //Click Properties Link
			Thread.sleep(3000);
			}
		
	// Value for Post Title
		public void postTitle(String postTitle) throws InterruptedException {
			
			this.postTitle.clear();
			this.postTitle.sendKeys(postTitle); 
			
		}

		
	/*	private Object switchTo() {
		driver.findElement(By.id("")).click();
		
		return null;
	} */

		// Value for Post Body
		public void postBody(String postBody) {
			driver.switchTo().frame("content_ifr");
			this.postBody.clear();
			this.postBody.sendKeys(postBody);
			driver.switchTo().defaultContent();
		}
		
		/* Scroll Down
				public void scroll() {
					JavascriptExecutor jse = (JavascriptExecutor)driver;
					jse.executeScript("window.scrollBy(100,-550)");
				} */
		
		public void categoryClick() throws InterruptedException // Click Post Category
		{
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//*[@id='in-category-185']")).click();
		//	this.categorySel.click();
		
			
			driver.findElement(By.xpath("//input[@id='publish']")).click();
			Thread.sleep(5000);
		}
		
		public void dashboard() throws InterruptedException
		{
		//	driver.findElement(By.linkText("Dashboard")).click();
		// Activity section is not available in Dashboard after portal refresh	
			Thread.sleep(3000);
			driver.findElement(By.linkText("View Post")).click();
		}
		
}