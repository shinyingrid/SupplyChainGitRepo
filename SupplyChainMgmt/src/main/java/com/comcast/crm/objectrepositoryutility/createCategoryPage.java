package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Rule 1: Create a class for ever web page
public class createCategoryPage 
{
	//Rule 2: Object Declaration
	@FindBy(xpath="//input[@value='+ Add Category']")
	private WebElement addMCatBtn;
	
	@FindBy(xpath="//input[@value='Delete']")
	private WebElement delMCatBtn;
	
	//Rule 3: Object Initialization
		WebDriver driver;
		 public createCategoryPage(WebDriver driver) {             
			 this.driver = driver;
			 PageFactory.initElements(driver, this);
	 }
		//Rule 4: Encapsulation 
		public WebElement getAddMCatBtn() {
			return addMCatBtn;
		}
		public WebElement getDelMCatBtn() {
			return delMCatBtn;
		}
		 
	
}
