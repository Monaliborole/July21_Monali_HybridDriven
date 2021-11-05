package com.technocredits.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;

import com.technocredits.orangehrm.base.PredefinedActions;

public class PIM_AddEmployeePage extends PredefinedActions {

	public PIM_AddEmployeePage setEmpFirstName(String fname) {
		driver.findElement(By.xpath("//input[@id='first-name-box']")).sendKeys(fname);
		return this;
	}

	public PIM_AddEmployeePage setEmpMiddleName(String middleName) {
		driver.findElement(By.xpath("//input[@id='middle-name-box']")).sendKeys(middleName);
		return this;
	}

	public PIM_AddEmployeePage setEmpLastName(String lastName) {
		driver.findElement(By.xpath("//input[@id='last-name-box']")).sendKeys(lastName);
		return this;
	}

	public PIM_AddEmployeePage setEmpLocation(String location) {
		driver.findElement(By.xpath("//button[@data-id='location']")).click();
		driver.findElement(By.xpath("//span[text()='"+location+"']//parent::a")).click();
		return this;
	}
	
	public PIM_AddEmployeePage clickOnNext() {
		driver.findElement(By.xpath("//button[text()='Next']")).click();
		return this;
	}

	public void addEmployeeInfo(String fname,String middleName,String lastName,String location) {
		setEmpFirstName(fname);
		setEmpMiddleName(middleName);
		setEmpLastName(lastName);
		setEmpLocation(location);
	}
	
	public PIM_AddEmployeePage setHobbies(String hobbies) {
		driver.findElement(By.xpath("//div//label[text()='Hobbies']/preceding-sibling::input")).sendKeys(hobbies);
		return this;
	}

	public PIM_AddEmployeePage setWorkShift(String shiftValue) {
		try {
		driver.findElement(By.xpath("//div[@id='work_shift_id_inputfileddiv']")).click();
		}catch(StaleElementReferenceException se) {
			driver.findElement(By.xpath("//div[@id='work_shift_id_inputfileddiv']")).click();
		}
		
		driver.findElement(By.xpath("//div/input[@value='Default Shift']//following-sibling::ul/li[span='"+shiftValue+"']")).click();
		return this;
		
	}
	
	public PIM_AddEmployeePage effectiveFrom(String month,String year,String date) {
		System.out.println("STEP : click on effective from calender button");
		driver.findElement(By.xpath("//input[contains(@class,'nput ng-not-empty ng-valid-schema-form')]//following-sibling::i[@class='material-icons action-icon date-picker-open-icon']")).click();
		
		System.out.println("STEP : select month from drop down");
		driver.findElement(By.xpath("//div[@class='select-wrapper picker__select--month']//input[@class='select-dropdown']")).click();
		driver.findElement(By.xpath("//div[@class='select-wrapper picker__select--month']//ul/li/span[text()='"+month+"']")).click();
		
		System.out.println("STEP : select year from drop down");
		driver.findElement(By.xpath("//div[@class='select-wrapper picker__select--year']//input[@class='select-dropdown']")).click();
		driver.findElement(By.xpath("//div[@class='select-wrapper picker__select--year']//ul//li/span[text()='"+year+"']")).click();
		
		System.out.println("STEP : select date");
		driver.findElement(By.xpath("//input[@id='add_employee_effective_date']//following-sibling::span[1]//div[text()='"+date+"']")).click();
		return this;	
	}
	
	public PIM_AddEmployeePage setRegion(String region) {
		System.out.println("STEP : select region from drop down");
		driver.findElement(By.xpath("//div[@id='9_inputfileddiv']//input[@class='select-dropdown']")).click();
		driver.findElement(By.xpath("//div[@id='9_inputfileddiv']//ul/li/span[text()='"+region+"']")).click();
		return this;
		
	}
	
	public PIM_AddEmployeePage setFTE(String fte) {
		System.out.println("STEP : select FTE");
		driver.findElement(By.xpath("//div[@id='10_inputfileddiv']//input")).click();
		driver.findElement(By.xpath("//div[@id='10_inputfileddiv']//ul/li/span[text()='"+fte+"']")).click();
		
		return this;
	}
	
	public PIM_AddEmployeePage setTempororyDepartment(String tempDept) {
		driver.findElement(By.xpath("//div[@id='11_inputfileddiv']//input")).click();
		driver.findElement(By.xpath("//div[@id='11_inputfileddiv']//ul/li/span[text()='"+tempDept+"']")).click();
		return this;
	}
	
	public PIM_AddEmployeePage clickOnSaveButton() {
		driver.findElement(By.xpath("//button[@class='btn waves-effect waves-light right' and text()='Save']")).click();
		return this;
	}
	
	public boolean verifyEmployeeSave() {
		return driver.findElement(By.xpath("//div[text()='Successfully Saved']")).isDisplayed();
	}


}
