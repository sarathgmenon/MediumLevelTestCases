package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AddFeature {
	private WebDriver driver; 



	public AddFeature(WebDriver driver) {
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
	
	//Finding Apply Button
	@FindBy(id="doaction")
	private WebElement applyBtn;

	
	//Finding Feature Name
	@FindBy(name="tag-name")
	private WebElement tagName;
	
	//Finding  Slug
	@FindBy(id="tag-slug")
	private WebElement slug;
	
	//Finding Description
	@FindBy(name="description")
	private WebElement featureDescr;
	
	//Finding Add New Feature button
	@FindBy(name="submit")
	private WebElement addnewFeatbtn;
	
	//Finding Feature Search Box
	@FindBy(id="tag-search-input")
	private WebElement featureSearch;
	
	//Finding Feature Search Button
	@FindBy(id="search-submit")
	private WebElement searchSbmBtn;
	
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
	
	//Clicking on Features
	public void featuresClick() throws InterruptedException {
		driver.findElement(By.linkText("Features")).click();
		Thread.sleep(2000);
	}
	
	// Value for New Feature
	public void sendtagName(String tagName) {
		this.tagName.clear();
		this.tagName.sendKeys(tagName); //Feature Name Input
	}
	
	// Value for New Feature
		public void sendslug(String slug) {
			this.slug.clear();
			this.slug.sendKeys(slug); //Slug Input
		}
	
	// Value for New Feature
		public void sendfeatureDescr(String featureDescr) {
			this.featureDescr.clear();
			this.featureDescr.sendKeys(featureDescr); //Description Input
		}
		
		
		//Clicking on Add New Feature button
		public void clickaddnewFeatBtn() throws InterruptedException {
			this.addnewFeatbtn.click(); 
			
		}
		
		// Scroll up the page
		public void scrollup() {
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,-550)");
		}
	
		// Value for Search Feature
		public void sendfeatureSearch(String featureSearch) throws InterruptedException {
			this.featureSearch.clear();
			this.featureSearch.sendKeys(featureSearch); //Search Input
			Thread.sleep(2000);
					
		}
		
			
		//Clicking on Search Feature button
		public void clicksearchSbmBtn() throws InterruptedException {
	//	WebElement element = driver.findElement(By.id("search-submit"));
	//	Actions action = new Actions(driver);
	//	action.moveToElement(element).click().build().perform();
		this.searchSbmBtn.click(); 
    			
		}
		
}
