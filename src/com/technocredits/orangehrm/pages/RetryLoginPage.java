package com.technocredits.orangehrm.pages;

import org.openqa.selenium.By;

import com.technocredits.orangehrm.base.PredefinedActions;

public class RetryLoginPage extends PredefinedActions{

	public String getRetryLoginPageMessage() {
		return driver.findElement(By.xpath("//div[@class='dashboardCard-title-for-card']")).getText();
	}
	
}
