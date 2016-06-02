package com.macys.pages;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {

		this.driver = driver;
	}

	public JeansPage pageDetail(){
		driver.findElement(By.id("globalSearchInputField")).sendKeys("jeans");
		driver.findElement(By.id("subnavSearchSubmit")).click();

		return new JeansPage(driver);
	}


}

