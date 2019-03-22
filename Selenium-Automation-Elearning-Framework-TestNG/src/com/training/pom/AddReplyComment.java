package com.training.pom;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AddReplyComment {
	private WebDriver driver; 


	public AddReplyComment(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
/////////////************* User Adds Comment in Blog Post ***********////////////////	
	//Finding Comment box
	@FindBy(id="comment")
	private WebElement commentBox;
	
	//Finding Commentor Name
	@FindBy(id="author")
	private WebElement commentName;

	//Finding Commentor email
	@FindBy(id="email")
	private WebElement emailId;
	
	@FindBy(tagName="body")
	private WebElement openNewWindow;

//	private String baseUrl;
//	baseUrl = properties.getProperty("baseURL");
	
	// Finding User Id
	@FindBy(id="user_login")
	private WebElement userName; 
			
	// Finding Password
	@FindBy(id="user_pass")
	private WebElement password;
			
	//Finding  Login Button
	@FindBy(name="login")
	private WebElement loginBtn; 
	

	@FindBy(xpath="//a[@data-action='replyto']")
	private WebElement replyIcon;
	
	@FindBy(id="replycontent")
	private WebElement replyTextBox;
	
	public void blog() {
		driver.findElement(By.linkText("BLOG")).click();
		driver.findElement(By.xpath("//div[@id='post-3013']//a[@class='read-more'][contains(text(),'Read More')]")).click();
			
	}

	public void sendcommentBox(String commentBox, String commentName) {
		this.commentBox.clear();
		this.commentBox.sendKeys(commentBox); //Comment Input
		this.commentName.sendKeys(commentName); //Commentor Name
	
	}

	public void sendemail(String emailId) throws InterruptedException {
	this.emailId.sendKeys(emailId); // Email Id
	driver.findElement(By.xpath("//input[@id='submit']")).click();
	Thread.sleep(3000);
	}

/////////////************* End of User Adds Comment in Blog Post ***********////////////////		

	
	
/////////////************* Admin Adds Reply in Blog Post ***********////////////////		

	public void launchNewWindowAdminSite() throws Exception {  // Launching a new window
		this.openNewWindow.sendKeys(Keys.chord(Keys.CONTROL, "n"));
		driver.get("http://realestate.upskills.in/wp-admin/");
		
	
	} 
	
	public void scroll() {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,500)");	
	}
		
		public void sendUserName(String userName) {
			driver.findElement(By.xpath("//input[@id='user_login']")).click();
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
		
		public void comments() {
			driver.findElement(By.xpath("//li[@id='menu-comments']")).click();
			
		Actions actions = new Actions(driver);
		WebElement reply = driver.findElement(By.xpath("//table[1]/tbody[1]/tr[1]/td[2]/p[1]"));
		actions.moveToElement(reply).build().perform();
		}
		
		public void clickReplyIcon() {
			this.replyIcon.click(); 
			
		}
		
		public void sendReply(String replyTextBox) throws InterruptedException {
			this.replyTextBox.clear(); 
			this.replyTextBox.sendKeys(replyTextBox); 
			driver.findElement(By.xpath("//span[@id='replybtn']")).click();
			driver.navigate().refresh();
			driver.findElement(By.xpath("//tr[@class='comment byuser comment-author-admin bypostauthor even thread-even depth-1 approved']//span[@class='post-com-count-wrapper post-com-count-3013']//span[@class='comment-count-approved'][contains(text(),'2')]")).click();
			Thread.sleep(4000);
		}
	

/////////////*********** End of Admin Adds Reply in Blog Post ***********////////////////	
}
	
