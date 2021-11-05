package com.technocredits.orangehrm.testscripts;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.technocredits.orangehrm.pages.DashboardPage;
import com.technocredits.orangehrm.pages.MenuPage;

public class DashboardTest extends TestBase {

	SoftAssert softAssert = new SoftAssert();

	private MenuPage menuPage;
	@BeforeMethod
	public void setUp() {
		menuPage = super.steup();
	}
	
	@Test
	public void verifyWidgetsTest() {
		System.out.println("STEP : Verify Dashboard page title should be Dashboard");
		DashboardPage dashboardPage = new DashboardPage();
		String expectedPageHeaderTitle = "Dashboard";
		String actualPageHeaderTitle = dashboardPage.getPageHeaderTitle();
		softAssert.assertEquals(actualPageHeaderTitle, expectedPageHeaderTitle,
				"Expected title was not displayed on page");

		System.out.println("STEP : Verify dashboard page title ");
		String actualDashboardPageTitle = dashboardPage.getPageTitle();
		String expectedDashboardPageTitle = "Dashboard";
		softAssert.assertEquals(actualDashboardPageTitle, expectedDashboardPageTitle);

		System.out.println("STEP : Verify 12 widgets displayed on dashboard page");
		int actualWidgets = dashboardPage.verifyWidgetsCount();

		softAssert.assertEquals(actualWidgets, 12);
		softAssert.assertAll();

		System.out.println("STEP: Verify widgets names on dashboard page");
		List<String> expectedWidgetList = new ArrayList<String>();
		expectedWidgetList.add("Quick Access");
		expectedWidgetList.add("Buzz Latest Posts");
		expectedWidgetList.add("Employee Job Details");
		expectedWidgetList.add("My Actions");
		expectedWidgetList.add("Headcount by Location");
		expectedWidgetList.add("Employees on Leave Today");
		expectedWidgetList.add("Time At Work");
		expectedWidgetList.add("Performance Quick Feedback");
		expectedWidgetList.add("Annual basic payment by Location");
		expectedWidgetList.add("Latest Documents");
		expectedWidgetList.add("Latest News");
		expectedWidgetList.add("Yearly New Hires");

		List<String> actualWidgetList = dashboardPage.verifyWidgetsNames();
		System.out.println(actualWidgetList);
		System.out.println(expectedWidgetList);
		Assert.assertTrue(actualWidgetList.equals(expectedWidgetList));
	}
	
	@AfterMethod
	public void tearDown() {
		super.tearDown();
	}
}
