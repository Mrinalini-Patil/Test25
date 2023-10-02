package File_Upload_Download;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class File_Upload
{
	public static void main(String[] args) throws AWTException
	{
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origine=*","ignore-certificate-errors");
		WebDriver driver = new ChromeDriver(co);
		
		//Open application
		driver.get("https://www.ilovepdf.com/pdf_to_word");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//To select file
		driver.findElement(By.xpath("//*[@id='pickfiles']")).click();
		
		//To copy file to clipboard(ctrl+c)
		
		StringSelection s = new StringSelection("C:\\Users\\Tejas\\OneDrive\\The moon God and the king of elephant 2.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s,null);
		
		//here we need to create object of Robot class because we require methods of Robot class to press ctrl+c and ctrl+v
		
		Robot R = new Robot();
		//to wait
		R.delay(2000);
		//TO press ctrl+v
		R.keyPress(KeyEvent.VK_CONTROL);
		R.keyPress(KeyEvent.VK_V);
		
		//To Release ctrl+v
		R.keyRelease(KeyEvent.VK_CONTROL);
		R.keyRelease(KeyEvent.VK_V);
		
		//To press Enter Key
		R.keyPress(KeyEvent.VK_ENTER);
		R.keyRelease(KeyEvent.VK_ENTER);
		
		
	} 
	 
	

}
