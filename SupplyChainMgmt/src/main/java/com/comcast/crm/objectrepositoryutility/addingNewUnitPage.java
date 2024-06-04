package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

//Rule 1: Create a java class for each webpage
public class addingNewUnitPage
{
	//Rule 2: Object Declaration
	@FindBy(xpath="//input[@id='unitName']")
	private WebElement mUnitNameEdt;
	
	@FindBy(xpath="//textarea[@id='unitDetails']")
	private WebElement mUnitDetailsEdt;
	
	@FindBy(xpath="//input[@value='Add Unit']")
	private WebElement mUnitSaveBtn;
	
	
	//Rule 3: Object Initialization
			WebDriver driver;
			public addingNewUnitPage(WebDriver driver)
			{
				this.driver=driver;
				PageFactory.initElements(driver, this);
			}
	
	//Rule 4: Encapsulation
	public WebElement getmUnitNameEdt() {
		return mUnitNameEdt;
	}
	public WebElement getmUnitDetailsEdt() {
		return mUnitDetailsEdt;
	}
	public WebElement getmUnitSaveBtn() {
		return mUnitSaveBtn;
	}
	
	//Rule 5: Object Utilization
	public void createNewMUnit() throws Throwable
	{
		manufacturerHomePage mhpPOM = new manufacturerHomePage(driver);
		mhpPOM.clickOnManageUnit();
		
		ManageUnitPage muPOM = new ManageUnitPage(driver);
		muPOM.getAddNewMUnitBtn().click();
		
		ExcelUtility elib=new ExcelUtility();
		String unitName = elib.getDataFromExcel("manufacturer", 1, 2);
		mUnitNameEdt.sendKeys(unitName);
		mUnitDetailsEdt.sendKeys(unitName+" is added");
		mUnitSaveBtn.click();
		
		WebDriverUtility wlib = new WebDriverUtility();
		wlib.switchtoAlertAndAccept(driver);
		
	}
	
		
		
}
