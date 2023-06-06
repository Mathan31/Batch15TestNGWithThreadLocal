package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;

import base.BaseClass;
import libraries.SeleniumWrapper;

public class RegistrationPage extends BaseClass{
	
	private By oFirstName = By.id("firstName");
	private By oMiddleName = By.id("middleName"); 
	private By oLastName = By.id("lastName");
	private By oUserName = By.id("username");
	private By oEmail = By.id("email");
	private By oPassword = By.id("password");
	private By oRegister = By.xpath("//button[text()='Register']");
	private By oTitle = By.id("title");
	private By oGender = By.id("sex");
	private By oUILogo = By.xpath("//a[@class='navbar-brand']");
	
	public boolean verifyAllTheRegistrationFields() {
		if(verifyDisplayedwithReturn(getDriver().findElement(oUserName)) && verifyDisplayedwithReturn(getDriver().findElement(oPassword))
				&& verifyDisplayedwithReturn(getDriver().findElement(oEmail))&& verifyDisplayedwithReturn(getDriver().findElement(oRegister),"Register Button")) {
			return true;		
		}else {
			return false;
		} 
	}
	
	public RegistrationPage enterFirstName(String fName) {
		type(getDriver().findElement(oFirstName), fName);
		return this;
	}
	
	public RegistrationPage selectTitle(String title) {
		selectDropDownUsingVisibleText(getDriver().findElement(oTitle), title);
		return this;
	}
	
	public RegistrationPage enterMiddleName(String mName) {
		type(getDriver().findElement(oMiddleName), mName);
		return this;
	}
	
	public RegistrationPage enterLastName(String lName) {
		type(getDriver().findElement(oLastName), lName);
		return this;
	}
	
	public RegistrationPage selectGender(String gender) {
		selectDropDownUsingVisibleText(getDriver().findElement(oGender), gender);
		return this;
	}
	
	public RegistrationPage enterUserName(String uName) {
		type(getDriver().findElement(oUserName), uName);
		return this;
	}
	
	public RegistrationPage enterEmail(String email) {
		type(getDriver().findElement(oEmail), email);
		return this;
	}
	
	public RegistrationPage enterPassword(String password) {
		type(getDriver().findElement(oPassword), password);
		return this;
	}
	
	public EmailVerificationPage clickOnRegisterBtn() {
		click(getDriver().findElement(oRegister));
		return new EmailVerificationPage();
	}

	public LoginPage clickOnUILogo() {
		click(getDriver().findElement(oUILogo));
		return new LoginPage();
	}
}
