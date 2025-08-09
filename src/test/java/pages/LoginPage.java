package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	WebDriver driver;
	
	//Locators
	private By emailField = By.id("formEmail");
	private By passwordInput = By.id("formPassword");
	private By loginButton = By.cssSelector("button.login-button");
	private By eyeIcon = By.cssSelector("img.passowrd-visible");
	private By errorMessage = By.cssSelector("p.normal-text");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Methods
	public void enterEmail(String email){
		driver.findElement(emailField).sendKeys(email);
	}
	
	public void enterPAssword(String password){
		driver.findElement(passwordInput).sendKeys(password);
	}
	
	public void clickLoginButton(){
		driver.findElement(loginButton).click();
	}
	

	public void passwordVisibilityToggle() {
		driver.findElement(eyeIcon).click();
	}
	
	public boolean isLoginButtonEnabled () {
		return driver.findElement(loginButton).isEnabled();
	}
	
	public String getPasswordFieldType(){
		return driver.findElement(passwordInput).getAttribute("type");
	}
	
	public String getErrorMessage(){
		//WebElement errorMsg = driver.findElement(By.className("ERROR: Invalid Login"));
		return driver.findElement(errorMessage).getText();
	}
}
