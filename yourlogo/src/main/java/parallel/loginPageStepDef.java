package parallel;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.CustomerPage;
import Pages.HomePage;
import Pages.SignInPage;
import io.cucumber.java.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
//import junit.framework.Assert;

public class loginPageStepDef {
	
	WebDriver driver = null;
	HomePage homePage;
	 SignInPage signInPage;
	 CustomerPage customerPage;
	 
	@Given("I navigate to automation practice page")
	public void i_navigate_to_automation_practice_page() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Given("I click on Sign In Button")
	public void i_click_on_sign_in_button() throws InterruptedException {
	  	homePage = new HomePage(driver);
		homePage.clickSignIn();
	    Thread.sleep(3000);
	    
	}

	@Then("validate Sign In page is displayed")
	public void validate_sign_in_page_is_displayed() {
		 signInPage= new SignInPage (driver);
		 Assert.assertTrue(signInPage.checkSignInBtnDisplay());
		}

	@When("enter valid user name and password")
	public void enter_valid_user_name_and_password() {
	    signInPage.enterEmail("pop@pop.com");
	    signInPage.enterPasswd("password");
	    
	}

	@When("click Sign in button")
	public void click_sign_in_button() {
	    signInPage.clickonSignin();
		
	}

	@Then("Validate if user home page is displayed")
	public void validate_if_user_home_page_is_displayed() {
		customerPage= new CustomerPage(driver);
		
	   
	    Assert.assertTrue(customerPage.headerDisplay());
	    
	}
	
	@After
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			byte[] src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.log(scenario.getName() + "is failed");
			scenario.attach(src, "image/png", scenario.getName() + ".png");
					}		
		driver.quit();
	}

}
