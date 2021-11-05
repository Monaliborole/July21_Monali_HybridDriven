package com.technocredits.orangehrm.pages;

import java.util.List;

import org.openqa.selenium.By;

import com.technocredits.orangehrm.base.PredefinedActions;

public class UserProfilePage extends PredefinedActions {

	public void clickOnUserDropDown() {
		driver.findElement(By.xpath("//a[@id='user-dropdown']")).click();
	}

	public List<String> getUserDropDownOptions() {
		return getTextOfAllElements(
				"//ul[@id='user_menu']/li/a[text()='About' or text()='Change Password' or text()='Logout']");
	}

	public void getUserDropDownAboutOption() {
		driver.findElement(By.xpath("//ul[@id='user_menu']/li/a[text()='About']")).click();
	}

	public int getTotalAvaliableOptions() {
		return getUserDropDownOptions().size();
	}
}
