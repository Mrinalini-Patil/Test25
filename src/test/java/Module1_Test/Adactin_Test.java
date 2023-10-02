package Module1_Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Library_Files.BaseClass;
import Library_Files.UtilityClass;
import Module1.Adactin_Login;
import Module1.Adactin_Welcome;

public class Adactin_Test extends BaseClass
{
	//InitializeBrowser()
	//WebDriver driver;
	
	Adactin_Login login; 
	Adactin_Welcome wel;
	String TestCaseID;
		
	@BeforeClass
	public void OpenBrowser()
	{
		InitializeBrowser();
		
		//create object of POM class-I
		login = new Adactin_Login(driver);
				
		//Create Object of POM class-II
		wel = new Adactin_Welcome(driver);
	}
	@BeforeMethod
	public void LoginToApp() throws IOException
	{
		login.enterusername(UtilityClass.getDataFromPF("Username"));
		
		login.password(UtilityClass.getDataFromPF("Password"));
		
		login.Clicklogin();
		
	}
	@Test(priority = 1)                      //Test Method/case
	public void verifyUserName() throws EncryptedDocumentException, IOException 
	{
		TestCaseID = "TC100";
		String ActualUser = wel.usershow();
		 String ExpectedUser = UtilityClass.getDataFromExcelSheet(0, 0);
		 Assert.assertEquals(ActualUser, ExpectedUser);
	}
	
	@Test(priority = 2)
	public void  GetTitleOfApp() throws EncryptedDocumentException, IOException
	{
		TestCaseID = "TC101";
		String ActualTitle = driver.getTitle();
		String ExpectedTitle = UtilityClass.getDataFromExcelSheet(1,0);
		Assert.assertEquals(ActualTitle,ExpectedTitle);
	}
	
	@Test(priority = 3)
	public void BookAHotel() throws EncryptedDocumentException, IOException
	{
		TestCaseID = "TC002";
		wel.SelectLocation(UtilityClass.getDataFromExcelSheet(2, 0));
		wel.SelectHotels(UtilityClass.getDataFromExcelSheet(3, 0));
		wel.SelectRoomType(UtilityClass.getDataFromExcelSheet(4, 0));
		wel.SelectNumberOfRooms(UtilityClass.getDataFromExcelSheet(5, 0));
		wel.EnterCheckInDate(UtilityClass.getDataFromExcelSheet(6, 0));
		wel.EnterCheckOutDate(UtilityClass.getDataFromExcelSheet(7, 0));
		wel.SelectAdultsPerRoom(UtilityClass.getDataFromExcelSheet(8, 0));
		wel.SelectChildrenPerRoom(UtilityClass.getDataFromExcelSheet(9, 0));
		wel.ClickSearchBtn();
		wel.ClickRadoiBtn();
		wel.ClickContinueBtn();
		wel.EnterFirstName(UtilityClass.getDataFromExcelSheet(0, 1));
		wel.EnterLastName(UtilityClass.getDataFromExcelSheet(1, 1));
		wel.EnterBillingAddress(UtilityClass.getDataFromExcelSheet(2, 1));
		wel.CrediCardNumber(UtilityClass.getDataFromExcelSheet(3, 1));
		wel.CreditCardType(UtilityClass.getDataFromExcelSheet(4, 1));
		wel.SelectEDMonth(UtilityClass.getDataFromExcelSheet(5, 1));
		wel.SelectEDYear(UtilityClass.getDataFromExcelSheet(6, 1));
		wel.EnterCVVNumber(UtilityClass.getDataFromExcelSheet(7, 1));
		wel.ClickBookNowButton();
	}
	
	@AfterMethod
	public void LogoutFromApp(ITestResult Result ) throws IOException 
	{
		if(Result.getStatus()==ITestResult.FAILURE)
		{
			UtilityClass.CaptureScreenShot(driver, TestCaseID);
		}
			
		wel.Clicklogout();
		wel.LoginAgain1();
	}
	
	@AfterClass
	public void CloseBrowser() 
	{
		driver.close();
	}
}
