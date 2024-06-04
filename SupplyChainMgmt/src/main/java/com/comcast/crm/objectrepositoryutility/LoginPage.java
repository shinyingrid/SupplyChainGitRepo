package com.comcast.crm.objectrepositoryutility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

/**
 * 
 * @author Deepak
 * 
 * Contains Login page elements & business lib like login()
 *
 */  

//Rule-1  create a separte java class
public class LoginPage extends WebDriverUtility{                             
   	 	
	
	// Rule-2 Object Creation
	@FindBy(id="login:username")                        
	private WebElement usernameEdt;
	
	@FindBy(id="login:password")
	private WebElement passwordEdt;
	
	@FindBy(xpath = "//select[@name='login_type']")
	private WebElement logintypeDD;
	     
	@FindBy(xpath="//input[@type='submit']")
	private WebElement loginBtn;
	
	
	//Rule 3 : Object Initialization
	WebDriver driver;
	 public LoginPage(WebDriver driver) {             
		 this.driver = driver;
		 PageFactory.initElements(driver, this);
	 }
	     
	 
	//Rule-4 : Object Encapsulation
	public WebElement getUsernameEdt() {            
		return usernameEdt;                        
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
/**
 *  login to application based username , password , url argumnets 
 * @param url
 * @param username
 * @param password
 */
	
	//Rule-5 : Object Utilization
	 public void loginToapp(String url , String username , String password) {
		 waitForPageToLoad(driver);
		 driver.get(url);	
		// driver.manage().window().maximize();
		 usernameEdt.sendKeys(username);
		 passwordEdt.sendKeys(password);
		 
		 WebDriverUtility wlib = new WebDriverUtility();
		 wlib.select(logintypeDD, "Manufacturer");
		 
		 loginBtn.click();
	 }
	
	
}
