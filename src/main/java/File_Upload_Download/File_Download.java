package File_Upload_Download;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class File_Download 
{
	public static void main(String[] args)
	{
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origine=*","ignore-certificate-error");
		
		String s1 = System.getProperty("user.dir")+"\\All downloads\\";
		HashMap mp = new HashMap();
		mp.put("download.default_directory",s1);
		
		//Set ChroeBrowser Settings
		co.setExperimentalOption("Prefs", mp);
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://chromedriver.storage.googleapis.com/index.html?path=114.0.5735.90/");
		 driver.manage().window().maximize();
		 	
		 //Wait
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 		 
		//Click on Zip file
		driver.findElement(By.xpath("//*[text()='chromedriver_win32.zip']")).click();
		

				
				
	}

}
