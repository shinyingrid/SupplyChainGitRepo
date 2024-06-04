package com.comcast.crm.objectrepositoryutility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

/**
 * 
 * @author Shiny Ingrid
 * 
 * Contains Login page elements & business lib like login()
 *
 */ 
//Rule 1: Create a java class for each web page
public class manufacturerHomePage extends WebDriverUtility{                             
                           
	WebDriver driver;
	
	//Rule 2: Object Declaration
	@FindBy(linkText = "Home")
	private WebElement manHomeLink;
	
	
	@FindBy(linkText = "Add Products")
	private WebElement addMProdLink;
	
	@FindBy(linkText = "Edit Profile")
	private WebElement editMProfileLink;
		
	@FindBy(linkText = "Manage Stock")
	private WebElement manageMStockLink;
		
	@FindBy(linkText = "Manage Unit")
	private WebElement manageMUnitLink;
	
	@FindBy(linkText = "Manage Category")
	private WebElement manageMCategoryLink;
	
	@FindBy(linkText = "Products")
	private WebElement productsTab;
	
	
	@FindBy(xpath="//input[@type='button']")
	private WebElement logoutLink;
	
	
	
	//Rule 3: Object Initialization
	 public manufacturerHomePage(WebDriver driver) {            
		 this.driver = driver;
		 PageFactory.initElements(driver, this);
	 }
	 
	 
	 //Rule 4: Encapsulation
	 
	 public WebElement getManHomeLink() {
			return manHomeLink;
		}
	 public WebElement getAddProdLink() {
			return addMProdLink;
		}

		public WebElement getLogoutLink() {
			return logoutLink;
		}
	 
		public WebElement getEditMProfileLink() {
			return editMProfileLink;
		}


		public WebElement getManageMStockLink() {
			return manageMStockLink;
		}


		public WebElement getManageMUnitLink() {
			return manageMUnitLink;
		}


		public WebElement getManageMCategoryLink() {
			return manageMCategoryLink;
		}
		
		public WebElement getProductsTab() {
			return productsTab;
		}
		
		
		// Rule 5: Object Utilization
		
		public void clickOnManHome()
		{
			manHomeLink.click();
		}	
		public void clickOnAddProduct()
		{
			addMProdLink.click();
		}	
		public void clickOnEditProfile()
		{
		editMProfileLink.click();
		}
		
		public void clickOnManageUnit() 
		{
		manageMUnitLink.click();
		}
		
		public void clickOnManageCategory() 
		{
		manageMCategoryLink.click();
		}
		public void clickOnManageStock() 
		{
		manageMStockLink.click();
		}	
		
		public void clickOnProductsTab()
		{
			productsTab.click();
		}

		public void clickOnLogout()
		{
			logoutLink.click();
		}
}
