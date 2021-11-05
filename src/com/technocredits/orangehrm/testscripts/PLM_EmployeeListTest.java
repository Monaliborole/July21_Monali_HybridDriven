package com.technocredits.orangehrm.testscripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.technocredits.orangehrm.pages.MenuPage;
import com.technocredits.orangehrm.pages.PLM_EmployeeListPage;

public class PLM_EmployeeListTest extends TestBase{

	private MenuPage menuPage;

	PLM_EmployeeListPage plm_empListPage=new PLM_EmployeeListPage();

	@BeforeMethod
	public void setUp() {
		menuPage = super.steup();
	}
	
	@Test
	public void verifyEmpCreated() {
		menuPage.navigateToMenu("PIM->Employee List");
		System.out.println("STEP : search by employee name");
		plm_empListPage.searchEmployeeName("John S Disouza");
		System.out.println("STEP : click on search button");
		plm_empListPage.clickOnSearch();
		System.out.println("STEP : After search correct employee should display");
		plm_empListPage.verifyEmpDisplayInList("John S Disouza");
		Assert.assertTrue(plm_empListPage.verifyEmpDisplayInList("John S Disouza"));
	}
	
	@AfterMethod
	public void tearDown() {
		super.tearDown();
	}
	

}
