package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AddPropertyWithAllDetails {
	private WebDriver driver; 



	public AddPropertyWithAllDetails(WebDriver driver) {
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
	
	//Finding New Property Title
	@FindBy(id="title")
	private WebElement  propTitle;
		
	//Finding New Property Content	
	@FindBy(id="content_ifr")
	private WebElement propContent;
	
	//Finding Publish button
	@FindBy(id ="publish")
	private WebElement publishBtn;
	
	//Finding Price Text box
	@FindBy(id="_price")
	private WebElement priceText;
	
	//Finding Price per SqFt
		@FindBy(id="_price_per")
		private WebElement priceSq;
		
	//Finding Status field
	@FindBy(id="_status")
	private WebElement status;
	
	//Finding Location
	@FindBy(id="_location")
	private WebElement location;
	
	//Finding Possession
	@FindBy(id="_possession")
	private WebElement possession;
	
	//Finding Location Address
	@FindBy(id="_friendly_address")
	private WebElement address;
	
	//Finding Map Address
	@FindBy(id="_address")
	private WebElement mapaddr;
		
	//Finding Latitude
	@FindBy(id="_geolocation_lat")
	private WebElement latitude;
		
	//Finding Longitude
	@FindBy(id="_geolocation_long")
	private WebElement longitude;
	
	//Finding Storage
	@FindBy(id="_storage_room")
	private WebElement storage;
	
	
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
	
	public void propClick()
	{
	driver.findElement(By.linkText("Properties")).click();
	driver.findElement(By.linkText("Add New")).click();
	}
	
	public void newProp(String propTitle, String propContent) throws InterruptedException
	{
		this.propTitle.sendKeys(propTitle); 
	//	driver.switchTo().frame("content_ifr");
		this.propContent.sendKeys(propContent);
	//	driver.switchTo().defaultContent();
	}
	
	public void price(String priceText, String priceSq) throws InterruptedException
	{
		this.priceText.sendKeys(priceText); 
	//	driver.switchTo().frame("content_ifr");
		this.priceSq.sendKeys(priceSq);
	//	driver.switchTo().defaultContent();
	}
	
	public void maindet(String status, String location, String possession) {
		driver.findElement(By.xpath("//a[@id='ui-id-2']")).click();
		this.status.sendKeys(status); 
		this.location.sendKeys(location); 
		this.possession.sendKeys(possession); 
	}
	
	public void locdet(String address, String mapaddr, String latitude, String longitude) {
	driver.findElement(By.xpath("//a[@id='ui-id-3']")).click();
	this.address.sendKeys(address);
	this.mapaddr.sendKeys(mapaddr);
	this.latitude.sendKeys(latitude);
	this.longitude.sendKeys(longitude);
	}
	
	public void details(String storage) throws InterruptedException
	{
		driver.findElement(By.xpath("//a[@id='ui-id-4']")).click();
		this.storage.sendKeys(storage);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='in-region-24']")).click();
		driver.findElement(By.xpath("//label[contains(text(),'Best')]")).click();
		driver.findElement(By.xpath("//input[@id='in-region-39']")).click();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,-550)");
		driver.findElement(By.xpath("//input[@id='publish']")).click();
		Thread.sleep(10000);
		
		
	}
	
	}
