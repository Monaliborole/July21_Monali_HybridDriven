package com.technocredits.orangehrm.pages;

import org.openqa.selenium.By;

import com.technocredits.orangehrm.base.PredefinedActions;

public class MenuPage extends PredefinedActions{

	public void navigateToMenu(String menu) {
		String arr[]=menu.split("->");
		for(String item:arr) {
			driver.findElement(By.xpath("//span[text()='"+item+"']")).click();
		}
		
		
	}
}
