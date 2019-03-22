package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class DeleteFeature {
	private WebDriver driver; 

//	JavascriptExecutor js = (JavaScriptExecutor) driver;
	public DeleteFeature(WebDriver driver) {
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

	
	//Finding Feature Name
	//@FindBy(name="tag-name")
	//private WebElement tagName;
		

	
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
	
	public void selFeature() throws InterruptedException
	{
		driver.findElement(By.name("delete_tags[]")).click();
		Thread.sleep(3000);
		
	}
	
	// Selecting option from Dropdown 
		public void dropdownSelect() {

			Select Actions = new Select(driver.findElement(By.id("bulk-action-selector-top")));
			Actions.selectByVisibleText("Delete");
		}
		
		public void clickApplyBtn() {
			this.applyBtn.click(); //Clicking on Apply button
		}
}
