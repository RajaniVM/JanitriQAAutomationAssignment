package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class LoginTests extends BaseTest {
	
	@Test
	public void testLoginButtonDisabledWhenfieldAreEmpty(){
		LoginPage loginPage = new LoginPage (driver);
		Assert.assertFalse(loginPage.isLoginButtonEnabled(), "Login button must be disabled");
	}
	
	@Test
	public void testPasswordMaskedByDefault() {
		LoginPage loginPage = new LoginPage(driver);
		String type = loginPage.getPasswordFieldType();
		
		Assert.assertEquals(type, "password", "Password field must be masked");
	}
	
	@Test
	public void testInvalidLoginShowError (){
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmail("abc@gmail.com");
		loginPage.enterPAssword("21ffr");
		loginPage.clickLoginButton();
		String errorMsg = loginPage.getErrorMessage();
		Assert.assertTrue(errorMsg.contains("Ivalid credentials"), "Expected 'Invalid Credentials' but found: " +errorMsg);
	}
}
