package com.technocredits.orangehrm.testscripts;

import com.technocredits.orangehrm.base.PredefinedActions;
import com.technocredits.orangehrm.pages.LoginPage;
import com.technocredits.orangehrm.pages.MenuPage;

public class TestBase {
	
	public MenuPage steup()  {
		System.out.println("STEP : Launch Orangehrm application");
		PredefinedActions.start();
		LoginPage loginPage = new LoginPage();
		System.out.println("STEP: Enter credentials");
		loginPage.enterCredentials("Admin", "@HJx4NpG1p");
		return loginPage.clickOnLoginButton();
	}

	
	public void tearDown() {
		PredefinedActions.closeBrowser();
	}

	

}
