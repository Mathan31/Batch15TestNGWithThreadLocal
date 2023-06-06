package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import base.BaseClass;
import libraries.SeleniumWrapper;

public class LoginPage extends BaseClass{
	
	private By oUsernameText = By.id("username");
	private By oPasswordText = By.id("password");
	private By oSignInBtn = By.xpath("//button[text()='Sign In']");
	private By oForgotLink = By.xpath("//*[text()='Register For Account']");
	private By oRegisterLink = By.xpath("//*[text()='Register For Account']");
	private By oLoginFailedInnerText = By.xpath("//div[contains(text(),'login failed')]");
	
	public boolean verifyElement() {
		if(verifyDisplayedwithReturn(getDriver().findElement(oUsernameText)) &&
				verifyDisplayedwithReturn(getDriver().findElement(oPasswordText))&&
				verifyDisplayedwithReturn(getDriver().findElement(oSignInBtn), "Sign In Button")&&
				verifyDisplayedwithReturn(getDriver().findElement(oForgotLink), "Forgot Link")&&
				verifyDisplayedwithReturn(getDriver().findElement(oRegisterLink), "Register Link")) {
				return true;
		}else {
			return false;
		}
	}
	
	public LoginPage enterUserName(String uName) {
		type(getDriver().findElement(oUsernameText), uName);
		return this;
	}
	
	public LoginPage enterPassword(String password) {
		type(getDriver().findElement(oPasswordText), password);
		return this;
	}
	
	public HomePage clickOnSignInButton() {
		click(getDriver().findElement(oSignInBtn));
		return new HomePage();
	}
	
	public LoginPage clickOnSignInButtonWithInvalid() {
		click(getDriver().findElement(oSignInBtn));
		return this;
	}
	
	public boolean validateLoginFailedText() {
		
		boolean result = verifyDisplayedwithReturn(getDriver().findElement(oLoginFailedInnerText), "Failure text");
		return result;
	}

	public RegistrationPage clickOnRegistrationLink() {
		click(getDriver().findElement(oRegisterLink));
		return new RegistrationPage();
	}
	

}
