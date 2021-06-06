package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	//Object Repo
	@FindBy (css="a.login")	
	WebElement lnk_signIn;
	
	
	public HomePage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	public void clickSignIn() {
		lnk_signIn.click();
	}
	
	
}
