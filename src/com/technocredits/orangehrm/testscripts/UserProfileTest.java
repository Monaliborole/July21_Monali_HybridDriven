package com.technocredits.orangehrm.testscripts;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.technocredits.orangehrm.pages.MenuPage;
import com.technocredits.orangehrm.pages.UserProfilePage;

public class UserProfileTest extends TestBase{

	UserProfilePage userProfilePage=new UserProfilePage();
	private MenuPage menuPage;
	@BeforeMethod
	public void setUp() {
		menuPage = super.steup();
	}
	
	/*@Test
	public void verifyClickonUserProfileDropDown() {
		System.out.println("STEP : Click on user profile");
		userProfilePage.clickOnUserDropDown();
		Assert.assertTrue(true);
	}*/
	
	@Test
	public void verifyListOfUserProfileDropDownOptions() throws InterruptedException {
		System.out.println("STEP : Verify user profile drop down options");
		List<String> expectedList=new ArrayList<>();
		expectedList.add("About");
		expectedList.add("Change Password");
		expectedList.add("Logout");
		userProfilePage.clickOnUserDropDown();
		List<String> actualList=userProfilePage.getUserDropDownOptions();
		System.out.println(actualList);
		System.out.println(expectedList);
		Assert.assertEquals(actualList, expectedList, "Actual list not matches with expected");
		
	}
	
	@Test(enabled=false)
	public void verifyUserDropDownAboutOption() {
		userProfilePage.getUserDropDownAboutOption();
		/*String expectedText="About";
		System.out.println(actualText + "-"+expectedText);
		Assert.assertEquals(actualText, expectedText);*/
	}
	
	@AfterMethod
	public void tearDown() {
		super.tearDown();
	}
	
	
}
