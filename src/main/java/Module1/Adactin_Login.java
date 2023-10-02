package Module1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Adactin_Login 
{
	
	//POM I
	//declare data members globally with access level private using @findby annotation
	@FindBy(xpath = "//input[@name = 'username'] ")private WebElement UN;
	@FindBy(id = "password")private WebElement PWD;
	@FindBy(xpath ="//input[@id='login']")private WebElement Login;
	
	//Initialize constructor with access level public using pagefactory class 
	public Adactin_Login(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//Utilize methods				
	public void enterusername(String user)
	{
		UN.sendKeys(user); //UserName------> Velocity
	}
	public void password( String pass)
	{
		PWD.sendKeys(pass);			//U1YP1G
	}
	public void Clicklogin()
	{
		Login.click();
	}

}
