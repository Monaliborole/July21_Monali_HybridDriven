package com.technocredits.orangehrm.testscripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.technocredits.orangehrm.pages.MenuPage;
import com.technocredits.orangehrm.pages.PIM_AddEmployeePage;

public class PIM_AddEmployeeTest extends TestBase {

	private MenuPage menuPage;

	PIM_AddEmployeePage pim_addEmployeePage = new PIM_AddEmployeePage();

	@BeforeMethod
	public void setUp() {
		menuPage = super.steup();
	}

	@Test
	public void verifyAddEmployeeTest() {
		menuPage.navigateToMenu("PIM->Add Employee");

		pim_addEmployeePage.setEmpFirstName("John").setEmpMiddleName("S").setEmpLastName("Disouza")
				.setEmpLocation("Australian Regional HQ").clickOnNext().setHobbies("reading").clickOnNext()
				.setWorkShift("Twilight").effectiveFrom("November", "2019", "20").setRegion("Region-1").setFTE("0.5")
				.setTempororyDepartment("Sub unit-2").clickOnSaveButton();
		
		Assert.assertTrue(pim_addEmployeePage.verifyEmployeeSave());
	}

	@AfterMethod
	public void tearDown() {
		super.tearDown();
	}

}
