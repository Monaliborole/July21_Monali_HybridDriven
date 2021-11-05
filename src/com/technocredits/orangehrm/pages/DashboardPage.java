package com.technocredits.orangehrm.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.technocredits.orangehrm.base.PredefinedActions;

public class DashboardPage extends PredefinedActions{

	public String getPageHeaderTitle() {
		return driver.getTitle();
	}
	
	public String getPageTitle() {
		return driver.findElement(By.xpath("//li[@class='page-title']")).getText();
	}
	
	public int verifyWidgetsCount() {
		return driver.findElements(By.xpath("//div[@id='widget.id']")).size();
	}
	
	public List<String> verifyWidgetsNames(){
		return getTextOfAllElements("//div[@class='widget-header']/span[2]");
	}
	
	
}
