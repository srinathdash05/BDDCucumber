package StepDefinitions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LogIn_PageObjects;

public class LoginTC {
	WebDriver driver = null;
	String url ="https://phptravels.net/login";
	//String username = "agent@phptravels.com";
	//String password = "demoagent";
	
	@SuppressWarnings("deprecation")
	@Given("User is on login page")
	public void launchBrowser() throws InterruptedException
	{
		driver= new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(3000);
	}
	@When("^user enters(.*) and (.*)$")
	public void enterIDPassword(String username, String password){
		PageFactory.initElements(driver, LogIn_PageObjects.class);
		LogIn_PageObjects.username.sendKeys(username);
		LogIn_PageObjects.password.sendKeys(password);
		
	}
	@And("Click on Log in button")
	public void clickLogin(){
		LogIn_PageObjects.LoginButton.click();
		
		
	}
	@Then("Navigated to the landing page")
	public void verifyLandingPage(){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement logo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@class='logo p-1 rounded']")));
		if(logo.isDisplayed()) {
			System.out.println("Log in successful");
			
		}else {
			System.out.println("Log in failed");
		}
		
		driver.close();
		driver.quit();
	}


}
