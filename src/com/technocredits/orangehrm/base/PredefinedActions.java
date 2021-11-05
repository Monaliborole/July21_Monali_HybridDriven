package com.technocredits.orangehrm.base;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PredefinedActions {

	
	protected static WebDriver driver;
	public static void start(String url) {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		System.out.println("STEP : open chrome browser");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("STEP : Enter url");
		driver.get(url);
		driver.manage().window().maximize();
		
	}

	public static void start() {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		System.out.println("STEP : open chrome browser");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("STEP : Enter url");
		driver.get("https://automationtrial-trials72.orangehrmlive.com/");
		driver.manage().window().maximize();
		
	}
	
	public static void closeBrowser() {
		driver.close();
	}
	
	public static void quitBrowser() {
		driver.quit();
	}
	
	protected List<String> getTextOfAllElements(String locator){
		List<WebElement> list = driver.findElements(By.xpath(locator));
		ArrayList<String> actualList = new ArrayList<String>();

		for (WebElement e : list) {
			actualList.add(e.getText());
		}
		return actualList;
	}
}
