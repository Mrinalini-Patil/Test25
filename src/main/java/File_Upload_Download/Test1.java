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

public class Test1
{
	public static void main(String[] args) throws AWTException
	{
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-originr=*","ignore-crtificate-errors");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.ilovepdf.com/pdf_to_word");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//to select file
		driver.findElement(By.xpath("//span[text()='Select PDF file']")).click();
		
		//to copy file to clipboard
		StringSelection s = new StringSelection("C:\\Mrinalini\\report1.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
		
		//
		Robot r = new Robot();
		r.delay(2000);
		
		//TO press Ctrl+V
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		
		//TO Release Ctrl+V
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		
		//TO press enter
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
	}

}
