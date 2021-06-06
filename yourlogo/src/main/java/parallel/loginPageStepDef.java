package parallel;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import Pages.HomePage;
import io.cucumber.java.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class loginPageStepDef {
	
	WebDriver driver = null;
	HomePage homePage;
	
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
	    //WebElement lnk_Sign_in = driver.findElement(By.cssSelector("a.login"));
	    //lnk_Sign_in.click();  
		homePage = new HomePage(driver);
		homePage.clickSignIn();
	    Thread.sleep(3000);
	    
	}

	@SuppressWarnings("deprecation")
	@Then("validate Sign In page is displayed")
	public void validate_sign_in_page_is_displayed() {
	    
	 WebElement btn_signin= driver.findElement(By.cssSelector("button#SubmitLogin"))  ;
	 Assert.assertTrue(btn_signin.isDisplayed());
	}

	@When("enter valid user name and password")
	public void enter_valid_user_name_and_password() {
	    // Write code here that turns the phrase above into concrete actions
	    
		driver.findElement(By.cssSelector("input#email1")).sendKeys("arunbabu79@gmail.com");
		driver.findElement(By.cssSelector("input#passwd")).sendKeys("password");
	}

	@When("click Sign in button")
	public void click_sign_in_button() {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.cssSelector("button#SubmitLogin")).click();
	}

	@SuppressWarnings("deprecation")
	@Then("Validate if user home page is displayed")
	public void validate_if_user_home_page_is_displayed() {
	    WebElement btn_myaccount= driver.findElement(By.cssSelector("div h1.page-heading"));
	    Assert.assertTrue(btn_myaccount.isDisplayed());
	    
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
