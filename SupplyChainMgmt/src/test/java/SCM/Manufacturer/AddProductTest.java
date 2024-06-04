package SCM.Manufacturer;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.addProductPage;
import com.comcast.crm.objectrepositoryutility.addingNewCategoryPage;
import com.comcast.crm.objectrepositoryutility.addingNewUnitPage;
import com.comcast.crm.objectrepositoryutility.manufacturerHomePage;

public class AddProductTest 
{
	WebDriver driver = null;
	
	@Test
	public void addProducttest() throws Throwable
	{
		//Handling the driver
		driver = new EdgeDriver();
		WebDriverUtility wlib = new WebDriverUtility();
		wlib.maximize(driver);
		wlib.waitForPageToLoad(driver);
		
		//Get common data
		FileUtility flib = new FileUtility();
		String BROWSER = flib.getDataFromPropertiesFile("browser");
		String URL = flib.getDataFromPropertiesFile("url");
		String USERNAME = flib.getDataFromPropertiesFile("username");
		String PASSWORD = flib.getDataFromPropertiesFile("password");
		
		//Login to application
		LoginPage lpPOM=new LoginPage(driver);
		lpPOM.loginToapp(URL, USERNAME, PASSWORD);
		
		
		//Creating a Unit
		addingNewUnitPage addNewMUnitPOM = new addingNewUnitPage(driver);
		addNewMUnitPOM.createNewMUnit();
		
		//Creating a Category
		addingNewCategoryPage addNewCatPOM = new addingNewCategoryPage(driver);
		addNewCatPOM.createNewMCategory();
		
		
		addProductPage addProdPOM= new addProductPage(driver);
		addProdPOM.addProductByMan();

		//Verification
		manufacturerHomePage mhPOM = new manufacturerHomePage(driver);
		mhPOM.clickOnProductsTab();
		
		ExcelUtility elib = new ExcelUtility();
		String prodName = elib.getDataFromExcel("manufacturer", 1, 0);
		
		List<WebElement> tableData = driver.findElements(By.xpath("//table[@class='table_displayData']/tbody/tr[*]/td[3]"));
		for(WebElement td : tableData)
		{
			String createdProdName = td.getText();
			if(createdProdName.contains("Sofa"))
			{
				System.out.println("Product verified");
			}
			
		}
		
		mhPOM.getLogoutLink().click();
		
		driver.quit();
		
			
	}
	
}
