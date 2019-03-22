package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class PropertyTrash {
	private WebDriver driver; 



	public PropertyTrash(WebDriver driver) {
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
	
	//Finding Post Title
	@FindBy(id="title")
	private WebElement postTitle;
	
	//Finding Post Body
	@FindBy(id="tinymce")
	private WebElement postBody;
	
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
		driver.findElement(By.linkText("Add New")).click(); //Click Add New
	}
	
	public void propValue(String postTitle)
	{
		this.postTitle.clear(); 
		this.postTitle.sendKeys(postTitle);
	}
	
	public void propValue2(String postBody)
	{
		driver.switchTo().frame("content_ifr");
		this.postBody.clear(); 
		this.postBody.sendKeys(postBody);
		driver.switchTo().defaultContent();
	}
	
	public void checkbox() throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@id='in-property_feature-135']")).click();
		driver.findElement(By.xpath("//input[@id='in-region-39']")).click();
		driver.findElement(By.linkText("Move to Trash")).click();
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@href='edit.php?post_status=trash&post_type=property']")).click();
	}
}

