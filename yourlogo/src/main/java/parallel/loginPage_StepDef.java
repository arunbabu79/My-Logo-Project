package parallel;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class loginPage_StepDef {
	
	WebDriver driver = null;
	
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
	    // Write code here that turns the phrase above into concrete actions
	    WebElement lnk_Sign_in = driver.findElement(By.cssSelector("a.login"));
	    lnk_Sign_in.click();  
	    Thread.sleep(3000);
	    
	}

	@Then("validate Sign In page is displayed")
	public void validate_sign_in_page_is_displayed() {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@When("enter valid user name and password")
	public void enter_valid_user_name_and_password() {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@When("click Sign in button")
	public void click_sign_in_button() {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("Validate if user home page is displayed")
	public void validate_if_user_home_page_is_displayed() {
	    // Write code here that turns the phrase above into concrete actions
	    
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}

}
