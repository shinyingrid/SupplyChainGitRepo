package SCM.Manufacturer;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.addingNewUnitPage;
import com.comcast.crm.objectrepositoryutility.ManageUnitPage;
import com.comcast.crm.objectrepositoryutility.manufacturerHomePage;

public class CreateUnitType_M 
{
	WebDriver driver;
	@Test
	public void createManUnitType() throws Throwable
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
				
				//Navigate to Manage Unit Link
				manufacturerHomePage mhpPOM = new manufacturerHomePage(driver);
								
				//Adding Unit
				mhpPOM.clickOnManageUnit();
				
				ManageUnitPage muPOM = new ManageUnitPage(driver);
				muPOM.getAddNewMUnitBtn().click();
				
				addingNewUnitPage addNewUnitPOM = new addingNewUnitPage(driver);
				ExcelUtility elib=new ExcelUtility();
				String unitName = elib.getDataFromExcel("manufacturer", 4, 2);
				addNewUnitPOM.getmUnitNameEdt().sendKeys(unitName);
				addNewUnitPOM.getmUnitDetailsEdt().sendKeys(unitName+" is added");
				addNewUnitPOM.getmUnitSaveBtn().click();
				wlib.switchtoAlertAndAccept(driver);
				
				//Verification
				mhpPOM.clickOnManageUnit();
				List<WebElement> unitNameColList=muPOM.getUnitNameColumn();
				for(WebElement l : unitNameColList)
				{
					String colName = l.getText();
					if(colName.contains(unitName))
					{
						System.out.println("Unit added ==> VERIFIED");
					}
				}
				
				mhpPOM.clickOnLogout();
				driver.quit();
	}
}
