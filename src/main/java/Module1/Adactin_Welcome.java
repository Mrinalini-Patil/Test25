package Module1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Adactin_Welcome 
{
	
	// Test case : To verify User 
	//POM II
	// declare data members globally with access level private using @FindBy Annotation
	
	@FindBy(xpath ="//input[@id='username_show']") private WebElement UserShow;
	@FindBy(xpath = "//a[text()='Logout']") private WebElement Logout;
	@FindBy(xpath = "//a[text()='Click here to login again']") private WebElement LoginAgain;
	
	@FindBy(xpath="//select[@id='location']") private WebElement Location;
	@FindBy(xpath="//select[@id='hotels']") private WebElement Hotels;
	@FindBy(xpath="//select[@id='room_type']") private WebElement RoomType;
	@FindBy(xpath = "//select[@id='room_nos']") private WebElement Number_of_rooms;
	@FindBy(xpath = "//input[@id='datepick_in']") private WebElement Check_In_Date;
	@FindBy(xpath = "//input[@id='datepick_out']") private WebElement Check_Out_Date;
	@FindBy(xpath = "//select[@id='adult_room']") private WebElement Adults_per_Room;
	@FindBy(xpath = "//select[@id='child_room']") private WebElement Children_per_Room;
	@FindBy(xpath="//*[@id='Submit']") private WebElement SearchBtn;
	@FindBy(xpath="//*[@id='radiobutton_0']") private WebElement RadioButton;
	@FindBy(xpath = "//*[@id='continue']") private WebElement Continue;
	
	@FindBy(xpath = "//*[@id='first_name']") private WebElement First_Name;
	@FindBy(xpath = "//*[@id='last_name']") private WebElement Last_Name ;
	@FindBy(xpath = "//*[@id='address']") private WebElement Billing_Address;
	@FindBy(xpath = "//*[@id='cc_num']") private WebElement Credit_Card_No;
	@FindBy(xpath = "//*[@id='cc_type']") private WebElement Credit_Card_Type;
	@FindBy(xpath = "//*[@id='cc_exp_month']") private WebElement ED_Month;
	@FindBy(xpath = "//*[@id='cc_exp_year']") private WebElement ED_Year;
	@FindBy(xpath = "//*[@id='cc_cvv']") private WebElement CVV_Number;
	@FindBy(xpath = "//*[@id='book_now']") private WebElement BookNowBtn;
	
	
	// Initialize in constructor with access level public using pagefactory class
	
	public Adactin_Welcome(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//utilize methods
	
	public String usershow()
	{
		String s = UserShow.getAttribute("value"); 		//Hello velocity!
		
		String[] A = s.split(" ");
		String a1 = A[0];
		String ActualUN = A[1];
		return ActualUN;					
	}
	public void Clicklogout()
	{
		Logout.click();
	}
	public void LoginAgain1()
	{
		LoginAgain.click();
	}
	
	public void SelectLocation(String LOC)
	{
		Select s = new Select(Location);
		s.selectByVisibleText(LOC);
	}
	public void SelectHotels(String HOT)
	{
		Select s = new Select(Hotels);
		s.selectByVisibleText(HOT);
	}
	public void SelectRoomType(String RT)
	{
		Select s = new Select(RoomType);
		s.selectByVisibleText(RT);
	}
	public void SelectNumberOfRooms(String NOR)
	{
		Select s = new Select(Number_of_rooms);
		s.selectByVisibleText(NOR);
	}
	public void EnterCheckInDate(String CD)
	{
		Check_In_Date.sendKeys(CD);
	}
	public void EnterCheckOutDate(String COD)
	{
		Check_Out_Date.sendKeys(COD);
	}
	public void SelectAdultsPerRoom(String ADPR)
	{
		Select s = new Select(Adults_per_Room);
		s.selectByVisibleText(ADPR);
	}
	public void SelectChildrenPerRoom(String CPR)
	{
		Children_per_Room.sendKeys(CPR);
	}
	public void ClickSearchBtn()
	{
		SearchBtn.click();
	}
	public void ClickRadoiBtn()
	{
		RadioButton.click();
	}
	public void ClickContinueBtn()
	{
		Continue.click();
	}
	public void EnterFirstName(String FName)
	{
		First_Name.sendKeys(FName);
	}
	public void EnterLastName(String LName)
	{
		Last_Name.sendKeys(LName);
	}
	public void EnterBillingAddress(String BillingAddress)
	{
		Billing_Address.sendKeys(BillingAddress);
	}
	public void CrediCardNumber(String CCN)
	{
		Credit_Card_No.sendKeys(CCN);
	}
	public void CreditCardType(String CCT)
	{
		Credit_Card_Type.sendKeys(CCT);
	}
	public void SelectEDMonth(String EDM)
	{
		Select s = new Select(ED_Month);
		s.selectByVisibleText(EDM);
	}
	public void SelectEDYear(String EDY)
	{
		Select s = new Select(ED_Year);
		s.selectByVisibleText(EDY);
	}
	public void EnterCVVNumber(String CVVNumber)
	{
		CVV_Number.sendKeys(CVVNumber);
	}
	public void ClickBookNowButton()
	{
		BookNowBtn.click();
	}

}
