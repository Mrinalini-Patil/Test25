package File_Upload_Download;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Test2_download 
{
	public static void main(String[] args)
	{
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origine=*","ignore-certificate-errors");
		WebDriver driver = new ChromeDriver();
		
		String s = System.getProperty("user.dir")+"\\All download\\";
		HashMap mp = new HashMap();
		mp.put("download.default_directory", s);
		
		//Set ChromeBrowser Settings
		co.setExperimentalOption("Prefs",mp);
		driver.get("");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}

}
