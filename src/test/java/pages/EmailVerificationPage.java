package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import base.BaseClass;
import libraries.SeleniumWrapper;

public class EmailVerificationPage extends BaseClass {

	private By oWelcome = By.xpath("//h2[contains(text(),'Welcome To The UiBank Family!')]");
	// private By oLogin = By.linkText("Login");
	private By oUILogo = By.xpath("//a[@class='navbar-brand']");
	
	public EmailVerificationPage verifyUserRegistration() {
		
		boolean displayed =verifyDisplayedwithReturn(getDriver().findElement(oWelcome), "Welcome Text");
		if (displayed) {
			System.out.println("User Registration is Successfull!!!");
		} else {
			System.out.println("User Registration is Not Successfull!!!");
		}
		return this;
	}

	public LoginPage clickOnUILogo() {
		click(getDriver().findElement(oUILogo),"UIBank Logo");
		return new LoginPage(); 
	}

}
