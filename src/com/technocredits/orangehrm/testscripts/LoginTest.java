package com.technocredits.orangehrm.testscripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.technocredits.orangehrm.pages.LoginPage;
import com.technocredits.orangehrm.pages.MenuPage;
import com.technocredits.orangehrm.pages.RetryLoginPage;

public class LoginTest extends TestBase {

	SoftAssert softAssert = new SoftAssert();
	LoginPage loginPage = new LoginPage();
	RetryLoginPage retryLoginPage = new RetryLoginPage();

	private MenuPage menuPage;

	@BeforeMethod
	public void setUp() {
		menuPage = super.steup();
	}

	@Test
	public void verifyLogoOnPage() {
		System.out.println("STEP : Verify logo display on login page");
		boolean isLogoDisplayed = loginPage.isLogoDisplayed();
		softAssert.assertTrue(isLogoDisplayed, "Logo was not displayed on Login Page");
	}

	@Test
	public void verifyLoginPanelOnPage() throws InterruptedException {
		System.out.println("STEP: Verify login panel display on login page");
		boolean isLoginPanelDisplayed = loginPage.isLoginPanelDisplayed();
		softAssert.assertTrue(isLoginPanelDisplayed, "Login Panel was not displayed on page");

	}

	@Test
	public void rightUserNameBlankPasswordLoginTest() {
		System.out.println("STEP: Enter credentials correct username and blank password");
		loginPage.enterCredentials("Admin", "");
		loginPage.clickOnLoginButton();
		String actualMessage = loginPage.getErrorMessage();
		String expectedMessage = "Password cannot be empty";
		System.out.println("Test Case result for right UserName and BlankPassword");
		softAssert.assertEquals(actualMessage, expectedMessage, "Expected message displayed after blank pwd");

	}

	@Test
	public void wrongUserNameRightPasswordLoginTest() {
		System.out.println("STEP: Enter credentials Wrong username and right password");
		loginPage.enterCredentials("Test", "@HJx4NpG1p");
		loginPage.clickOnLoginButton();
		String actualMessage = retryLoginPage.getRetryLoginPageMessage();
		String expectedMessage = "Retry Login";
		softAssert.assertEquals(actualMessage, expectedMessage, "Retry login page was not display");

	}

	@Test
	public void rightUserNameWrongPasswordLoginTest() {
		System.out.println("STEP: Enter credentials correct username and wrong password");
		loginPage.enterCredentials("Admin", "@HJx4N");
		loginPage.clickOnLoginButton();
		String actualMessage = retryLoginPage.getRetryLoginPageMessage();
		String expectedMessage = "Retry Login";
		softAssert.assertEquals(actualMessage, expectedMessage, "Retry login page was not display");

	}

	@Test
	public void verifySuccessfulLogin() {
		System.out.println("STEP: Enter credentials");
		loginPage.enterCredentials("Admin", "@HJx4NpG1p");
		loginPage.clickOnLoginButton();
		softAssert.assertAll();
	}

	@AfterMethod
	public void tearDown() {
		super.tearDown();
	}

}
