package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

//Rule 1: Create a class for ever web page
 public class addingNewCategoryPage 
{
	//Rule 2: Object Declaration
	 @FindBy(xpath="//input[@id='categoryName']")
	 private WebElement mCatNameEdt;
	 
	 @FindBy(xpath="//textarea[@id='categoryDetails']")
	 private WebElement mCatDetailsEdt;
	 
	 @FindBy(xpath="//input[@value='Add Category']")
	 private WebElement catSaveBtn;
	 
	//Rule 3: Object Initialization
			WebDriver driver;
			 public addingNewCategoryPage(WebDriver driver) {             
				 this.driver = driver;
				 PageFactory.initElements(driver, this);
		 }
			 
		//Rule 4: Encapsulation	 
			public WebElement getmCatNameEdt() {
				return mCatNameEdt;
			}
			public WebElement getmCatDetailsEdt() {
				return mCatDetailsEdt;
			}
			public WebElement getCatSaveBtn() {
				return catSaveBtn;
			}
			 
		//Rule 5: Object Utilization
			public void createNewMCategory() throws Throwable
			{
				manufacturerHomePage mhpPOM = new manufacturerHomePage(driver);
				mhpPOM.clickOnManageCategory();
				
				createCategoryPage cCatPOM = new createCategoryPage(driver);
				cCatPOM.getAddMCatBtn().click();
				
				ExcelUtility elib=new ExcelUtility();
				String catName = elib.getDataFromExcel("manufacturer", 1, 3);
				
				mCatNameEdt.sendKeys(catName);
				mCatDetailsEdt.sendKeys(catName+" is added");
				catSaveBtn.click();
				
				WebDriverUtility wlib = new WebDriverUtility();
				wlib.switchtoAlertAndAccept(driver);
				
			}
			 
}
