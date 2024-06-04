package SCM.Manufacturer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.editManProfilePage;
import com.comcast.crm.objectrepositoryutility.manufacturerHomePage;

import junit.framework.Assert;
//Creating a class
public class EditManProfileTest 
{
	@Test
	public void editMProfiletest() throws Throwable
	{
		WebDriver driver;
		
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
				
				//Edit Profile
				editManProfilePage empPOM = new editManProfilePage(driver);
				empPOM.editManProfile();
				
				manufacturerHomePage mhPOM = new manufacturerHomePage(driver);
				mhPOM.clickOnLogout();
				driver.quit();
				
	}
}
