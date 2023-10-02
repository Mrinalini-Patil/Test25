package Library_Files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class UtilityClass 
{
	//Name: Mrinalini
		//Date: 13/9/2023
		//Day: Wed
		//To fetch data from PF
		

	@Test								//Username
	public static String getDataFromPF(String key) throws IOException
	{
		// To reach property file
		FileInputStream file = new FileInputStream("C:\\Users\\Tejas\\eclipse-workspace\\15_apr_Maven\\PropFile.properties");
				
// To open file we have to create object of Properties class because we require load() of properties class which is non static
		Properties prop = new Properties();
		
		// To open file call load method and pass file object on which path of the property file is stored
		prop.load(file);
		
		// To fetch data from property file use getPropery() method
		String value1 = prop.getProperty(key);		//Username---> Velocity
		
		return value1;			//Velocity
	}
	//Name: Mrinalini
			//Date: 14/9/2023
			//Day: Thursday
			//To fetch data from Excelsheet

	
	@Test
	public static String getDataFromExcelSheet(int RowIndex, int CellIndex) throws EncryptedDocumentException, IOException
	{
		FileInputStream file = new FileInputStream("C:\\Users\\Tejas\\eclipse-workspace\\15_apr_Maven\\TestData\\15_April.xlsx");
		String value2 = WorkbookFactory.create(file).getSheet("sheet4").getRow(RowIndex).getCell(CellIndex).getStringCellValue();//C4472J
		
		return value2;
	}
	
	//Name: Mrinalini
	//Date : 
	//Day : Sunday
	//To capture ScreenShot
	
	public static void CaptureScreenShot(WebDriver driver, String TestCaseID) throws IOException
	{
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		System.out.println(source);
		File Dest = new File("C:\\Mrinalini\\Screenshot\\"+TestCaseID+".jpg");
		FileHandler.copy(source, Dest);
	}

}
