package com.macys.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	
	
	private final WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	// The HomePage contains several HTML elements that will be represented as WebElements.
	// The locators for these elements should only be defined once.			
	By closeButtonField = By.id("closeButton");
	By searchTextBox = By.id("globalSearchInputField");
	By submitButton = By.id("subnavSearchSubmit");

	public HomePage closePopUp()
	{
		try{
			driver.findElement(closeButtonField).click();
		}
		catch(Exception e)
		{
			System.out.println("Popup is not displayed " + e.getMessage());
		}
		return this;
	}
	public SearchResultsPage enterSearchDetails(String itemName)
	{
		driver.findElement(searchTextBox).clear();
		driver.findElement(searchTextBox).sendKeys(itemName);
		driver.findElement(submitButton).click();
		return new SearchResultsPage(driver);

	}



}
