package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class RealEstate_PropCheck {
	private WebDriver driver; 

	public RealEstate_PropCheck(WebDriver driver) {
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

	//Clicking on Properties & Selecting Check box
	public void propClick() throws InterruptedException {
		driver.findElement(By.linkText("Properties")).click(); //Click Properties Link
		Thread.sleep(3000);
		driver.findElement(By.name("post[]")).click(); 
	//	driver.findElement(By.xpath("//*[starts-with(@id,'cb-select-')]")).click(); //Checking First Entry (PrestigeKiran)
	}
	
	
	// Selecting option from Dropdown 
	public void dropdownSelect() {
		
		Select Actions = new Select(driver.findElement(By.name("action")));
		Actions.selectByVisibleText("Move to Trash");
	}
	
	public void clickApplyBtn() {
		this.applyBtn.click(); //Clicking on Apply button
	}
	
}
