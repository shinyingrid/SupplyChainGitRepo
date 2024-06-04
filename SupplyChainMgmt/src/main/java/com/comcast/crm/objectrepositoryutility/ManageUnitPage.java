package com.comcast.crm.objectrepositoryutility;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

//Rule 1: Create a java class for each webpage
public class ManageUnitPage 
{
	
	//Rule 2: Object Declaration
	@FindBy(xpath="//input[@value='+ Add Unit']")
	private WebElement addNewMUnitBtn;
	
	@FindBy(xpath="//input[@value='Delete']")
	private WebElement deleteMUnitFrmListBtn;
	
	@FindBy(xpath="//table[@class='table_displayData']")
	private WebElement manListTable;

	@FindBy(xpath="//table[@class='table_displayData']/tbody/tr[*]/td[3]")
	private List<WebElement> UnitNameColumn;
	
	//Rule 3: Object Declaration
	WebDriver driver;
	public ManageUnitPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	//Rule 4: Encapsulation
	public WebElement getAddNewMUnitBtn() {
		return addNewMUnitBtn;
	}

	public WebElement getDeleteMUnitFrmListBtn() {
		return deleteMUnitFrmListBtn;
	}

	public WebElement getManListTable() {
		return manListTable;
	}
	
	public List<WebElement> getUnitNameColumn() {
		return UnitNameColumn;
	}
	
	
	
}
