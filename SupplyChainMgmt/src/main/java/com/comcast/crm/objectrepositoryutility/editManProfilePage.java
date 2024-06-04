package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

import junit.framework.Assert;

//Rule 1: Create a java class for every web page
public class editManProfilePage
{
	//Rule 2: Object Declaration
	@FindBy(xpath="//input[@id='manufacturer:name']")
	private WebElement manProfileNameEdt;
	
	@FindBy(xpath="//input[@id='manufacturer:email']")
	private WebElement manProfileEmailEdt;
	
	@FindBy(xpath="//input[@id='manufacturer:phone']")
	private WebElement manProfilePhNoEdt;
	
	@FindBy(xpath="//input[@value='Change Password']")
	private WebElement manChangePwdBtn;
	
	@FindBy(xpath="//input[@value='Update Profile']")
	private WebElement manUpdateProfileBtn;
	
	@FindBy(xpath="//section/article[1]/table/tbody/tr[2]/td[1]")
	private WebElement updatedManName;
	
	@FindBy(xpath="//section/article[1]/table/tbody/tr[2]/td[2]")
	private WebElement updatedManEmail;
	
	@FindBy(xpath="//section/article[1]/table/tbody/tr[2]/td[3]")
	private WebElement updatedManPhNo;
	
	
	
	//Rule 3: Object Initialization
	WebDriver driver;
	public editManProfilePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Rule 4: Encapsulation

	public WebElement getManProfileNameEdt() {
		return manProfileNameEdt;
	}
	public WebElement getManProfileEmailEdt() {
		return manProfileEmailEdt;
	}
	public WebElement getManProfilePhNoEdt() {
		return manProfilePhNoEdt;
	}
	public WebElement getManChangePwdBtn() {
		return manChangePwdBtn;
	}
	public WebElement getManUpdateProfileBtn() {
		return manUpdateProfileBtn;
	}
	
	
	//Rule 5: Object Utilization
	public void editManProfile() throws Throwable
	{
		manufacturerHomePage mhPOM = new manufacturerHomePage(driver);
		mhPOM.clickOnEditProfile();
		
		ExcelUtility elib = new ExcelUtility();
		String manName = elib.getDataFromExcel("ManProfile", 4, 0);
		String manEmail = elib.getDataFromExcel("ManProfile", 4, 1);
		String manPhNo = elib.getDataFromExcel("ManProfile", 4, 2);
		
		manProfileNameEdt.clear();
		manProfileNameEdt.sendKeys(manName);
		
		manProfileEmailEdt.clear();
		manProfileEmailEdt.sendKeys(manEmail);;
		
		manProfilePhNoEdt.clear();
		manProfilePhNoEdt.sendKeys(manPhNo);
		
		manUpdateProfileBtn.click();
		
		WebDriverUtility wlib = new WebDriverUtility();
		wlib.switchtoAlertAndAccept(driver);
		
		mhPOM.clickOnManHome();
		String upManName = updatedManName.getText();
		String upManEmail = updatedManEmail.getText();
		String upManPhNo = updatedManPhNo.getText();
		
		Assert.assertEquals(upManName, manName);
		Assert.assertEquals(upManEmail, manEmail);
		Assert.assertEquals(upManPhNo, manPhNo);
		System.out.println("Manufacturer Profile updated ==>VERIFIED");
		
	}
	
	
	public void verifyManProfile()
	{
//		String updatedManName=driver.findElement(By.xpath("//section/article[1]/table/tbody/tr[2]/td[1]")).getText();
//		String updatedManEmail=driver.findElement(By.xpath("//section/article[1]/table/tbody/tr[2]/td[2]")).getText();
//		String updatedManPhNo=driver.findElement(By.xpath("//section/article[1]/table/tbody/tr[2]/td[3]")).getText();
//		

		
	}
	
	
}
