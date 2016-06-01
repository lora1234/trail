package com.macys.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.macys.util.Utility;

public class SearchResultsPage {

	
	
	
	private final WebDriver driver;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;	     
    }
    public boolean verifySearchResultsPageTile(String expected)
    {
    	return driver.getTitle().contains(expected);
    }
    public int getItemsDescriptionCount(String itemName)
    {
    	Utility.unconditionalWait(10000);
    	
    	int counter=0;
    	List<WebElement> list = driver.findElements(By.className("shortDescription"));
    	for(int i=0;i<list.size();i++)
    	{
    		if(list.get(i).getText().toLowerCase().contains(itemName))
    		{
    			counter++;
    		}
    	}
    	try{
    		//driver.findElement(By.cssSelector(".arrowRight.arrowButton.paginationSpacer")).click();
    		Utility.findWebElement(driver,"cssSelector",".arrowRight.arrowButton.paginationSpacer").click();
    	}
    	catch(Exception e)
    	{
    		System.out.println("NextPage Element not found " + e.getMessage());
    	}
    	return counter;
    }
}