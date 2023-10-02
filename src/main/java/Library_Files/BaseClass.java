package Library_Files;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass 
{
	public WebDriver driver;
	
	public void InitializeBrowser()
	{
		
		
		System.setProperty("webdriver.Chrome.driver", "C:\\mrinalini\\selenium\\chromeWin_32//chromedriver.exe");
		driver = new ChromeDriver();
		
		//To open application
		
		driver.get("http://adactinhotelapp.com/HotelAppBuild2/");
		
		driver.manage().window().maximize();
		
		//To provide wait 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

}
