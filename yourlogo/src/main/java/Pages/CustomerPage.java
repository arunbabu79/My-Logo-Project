package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerPage {
	@FindBy(css="div h1.page-heading")
	WebElement header_page;
	 
public CustomerPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
	
}

public boolean headerDisplay() {
	return header_page.isDisplayed();	
}



}
