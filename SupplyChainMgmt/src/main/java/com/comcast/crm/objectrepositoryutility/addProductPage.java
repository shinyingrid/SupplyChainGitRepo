package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

//Rule 1: Create a class for ever web page
public class addProductPage
{
	WebDriverUtility wlib = new WebDriverUtility();
	
	//Rule 2: Object Declaration
	@FindBy(xpath="//input[@id='product:name']")
	private WebElement prodNameEdt;
	
	@FindBy(xpath="//input[@id='product:price']")
	private WebElement prodPriceEdt;
	
	@FindBy(xpath = "//select[@name='cmbProductUnit']")
	private WebElement prodUnitTypeDD;
	
	@FindBy(xpath = "//select[@name='cmbProductCategory']")
	private WebElement prodCategoryDD;
	
	@FindBy(partialLinkText = "Enable")
	private WebElement prodEnableBtn;
	
	@FindBy(partialLinkText = "Disable")
	private WebElement prodDisableBtn;
	
	@FindBy(xpath="//input[@value='Add Product']")
	private WebElement addProdSubmitBtn;
	
	
	
	//Rule 3: Object Initialization
	WebDriver driver;
	 public addProductPage(WebDriver driver) {             
		 this.driver = driver;
		 PageFactory.initElements(driver, this);
	 }
	 
	 //Rule 4: Encapsulation
	public WebElement getProdNameEdt() {
		return prodNameEdt;
	}
	public WebElement getProdPriceEdt() {
		return prodPriceEdt;
	}
	public WebElement getProdUnitTypeDD() {
		return prodUnitTypeDD;
	}
	public WebElement getProdCategoryEdt() {
		return prodCategoryDD;
	}
	public WebElement getProdEnableBtn() {
		return prodEnableBtn;
	}
	public WebElement getProdDisableBtn() {
		return prodDisableBtn;
	}
	public WebElement getAddProdSubmitBtn() {
		return addProdSubmitBtn;
	}
	public WebDriver getDriver() {
		return driver;
	}
	
	//Rule 5: Object utilization
	
	public void addProductByMan() throws Throwable
	{
		manufacturerHomePage mhpPOM = new manufacturerHomePage(driver);
		mhpPOM.clickOnAddProduct();
		
		ExcelUtility elib = new ExcelUtility();
		String prodName = elib.getDataFromExcel("manufacturer", 1, 0);
		String prodPrice = elib.getDataFromExcel("manufacturer", 1, 1);
		String prodType = elib.getDataFromExcel("manufacturer", 1, 2);
		String prodCategory = elib.getDataFromExcel("manufacturer", 1, 3);
		
		prodNameEdt.sendKeys(prodName);
		prodPriceEdt.sendKeys(prodPrice);
		
		wlib.select(prodUnitTypeDD, prodType);
		wlib.select(prodCategoryDD, prodCategory);
		
		driver.findElement(By.xpath("(//input[@type='radio'])[1]")).click();
//		prodEnableBtn.click();
		
		addProdSubmitBtn.click();
		
		WebDriverUtility wlib = new WebDriverUtility();
		wlib.switchtoAlertAndAccept(driver);
	}
	
	 
	 
}
