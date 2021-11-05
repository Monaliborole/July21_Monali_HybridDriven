package com.technocredits.orangehrm.pages;

import org.openqa.selenium.By;

import com.technocredits.orangehrm.base.PredefinedActions;

public class PLM_EmployeeListPage extends PredefinedActions{

	
	public PLM_EmployeeListPage searchEmployeeName(String empName) {
		System.out.println("STEP : search by employee name");
		driver.findElement(By.xpath("//input[@id='employee_name_quick_filter_employee_list_value']")).sendKeys(empName);
		return this;
	}
	
	public PLM_EmployeeListPage clickOnSearch() {
		driver.findElement(By.xpath("//i[@id='quick_search_icon']")).click();
		return this;
	}
	
	public boolean verifyEmpDisplayInList(String empName) {
		return driver.findElement(By.xpath("//table[@id='employeeListTable']//td[contains(text(),'"+empName+"')]")).isDisplayed();
	}
	
	
	
}
