package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogIn_PageObjects {
	
	@FindBy(id ="email")
	public static WebElement username;
	
	@FindBy(id ="password")
	public static WebElement password;
	
	@FindBy(id ="submitBTN")
	public static WebElement LoginButton;
	
	@FindBy(xpath ="//img[@class='logo p-1 rounded']")
	public static WebElement LandingPageLogo;


}
