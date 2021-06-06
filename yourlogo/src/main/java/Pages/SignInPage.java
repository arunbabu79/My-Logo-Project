package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {

	@FindBy(css="input#email")
WebElement Inpt_email;	
	
	
	@FindBy(css="input#passwd")
WebElement Inpt_passwrd;
	
	
	@FindBy(css="button#SubmitLogin")
   WebElement btn_signin;	
		
	
	public SignInPage (WebDriver driver) {
	 PageFactory.initElements(driver, this);
	 
	}
	public void enterEmail(String email) {
		Inpt_email.sendKeys(email);
	}
	public void enterPasswd(String passwrd) {
		Inpt_passwrd.sendKeys(passwrd);
	}
	
	public void clickonSignin() {
		 btn_signin.click();
	}
	
	public boolean checkSignInBtnDisplay() {
		return btn_signin.isDisplayed();
	}
}