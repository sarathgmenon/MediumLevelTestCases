package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class AddNewRegProp_RETC089 {
	private WebDriver driver; 



	public AddNewRegProp_RETC089(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	

	// Finding User Id
	@FindBy(id="user_login")
	private WebElement userName; 
	
	// Finding Password
	@FindBy(id="user_pass")
	private WebElement password;
	
	//Finding  Login Button
	@FindBy(name="login")
	private WebElement loginBtn; 
	
	//Finding Apply Button
	@FindBy(id="doaction")
	private WebElement applyBtn;

	
	//Finding Region Name
	@FindBy(name="tag-name")
	private WebElement tagName;
	
	//Finding  Slug
	@FindBy(id="tag-slug")
	private WebElement slug;
	

	
	//Finding Description
	@FindBy(name="description")
	private WebElement regionDescr;
	
	//Finding Add New Region button
	@FindBy(name="submit")
	private WebElement addnewRegionbtn;
	
	//Finding Parent drop down
		@FindBy(id="parent")
		private WebElement parentdpdwn;
	
	//Finding Region Search Box
	@FindBy(id="tag-search-input")
	private WebElement regionSearch;
	
	//Finding Region Search Button
	@FindBy(id="search-submit")
	private WebElement searchSbmBtn;
	
	//Finding New Property Title
		@FindBy(id="title")
		private WebElement  propTitle;
		
		//Finding New Property Content	
		@FindBy(id="content")
		private WebElement propContent;
		
		//Finding Publish button
		@FindBy(id ="publish")
		private WebElement publishBtn;
	
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

	//Clicking on Properties 
	public void propClick() throws InterruptedException {
		driver.findElement(By.linkText("Properties")).click(); //Click Properties Link
		Thread.sleep(3000);
		
	}
	
	
	//Clicking on Regions
	
			public void regionlinkClick() throws InterruptedException {
				driver.findElement(By.linkText("Regions")).click();
				Thread.sleep(2000);
				
			}
	
	
	// Value for New Region
	public void sendtagName(String tagName) {
		this.tagName.clear();
		this.tagName.sendKeys(tagName); //Region Name Input
	}
	
	// Value for New Region
		public void sendslug(String slug) {
			this.slug.clear();
			this.slug.sendKeys(slug); //Slug Input
		}
		
	// Value for New Region
		public void parentdropdown() {
			this.parentdpdwn.click();
			Select Actions = new Select(driver.findElement(By.id("parent")));
				Actions.selectByValue("-1");
		}
	
	// Value for New Region
		public void sendregionDescr(String regionDescr) {
			this.regionDescr.clear();
			this.regionDescr.sendKeys(regionDescr); //Description Input
		}
		
		public void clickaddnewregionBtn() throws InterruptedException {
			this.addnewRegionbtn.click(); 
			
		}
		
		public void newProp(String propTitle, String propContent) throws InterruptedException
		{
			driver.findElement(By.xpath("//a[@href='post-new.php?post_type=property']")).click();
			Thread.sleep(2000);
			this.propTitle.sendKeys(propTitle); 
		//	driver.switchTo().frame("content_ifr");
			this.propContent.sendKeys(propContent);
		//	driver.switchTo().defaultContent();
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,-550)");
			
			driver.findElement(By.id("in-property_feature-247")).click();
			Thread.sleep(4000);
			this.publishBtn.click(); 
			Thread.sleep(4000); 
			driver.findElement(By.linkText("View post")).click();
			Thread.sleep(2000);
			
			JavascriptExecutor jse2 = (JavascriptExecutor)driver;
			jse2.executeScript("window.scrollBy(0,250)");
		}
		
}
