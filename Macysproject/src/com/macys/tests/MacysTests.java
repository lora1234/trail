package com.macys.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.macys.pages.HomePage;
import com.macys.pages.SearchResultsPage;
import com.macys.util.Utility;

import jxl.read.biff.BiffException;

public class MacysTests {

	

		
	WebDriver driver;
	HomePage hPage;
	SearchResultsPage sPage ;
	String url;
	
	@Parameters({"browserType","url"})
	@BeforeClass
	public void invokeBrowser(String browserType,String url)
	{
		if(browserType.equals("FF"))
		{
		
			  driver = new FirefoxDriver();
		}
		else if(browserType.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver","IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		else if(browserType.equals("CH"))
		{
			  System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			  driver  = new ChromeDriver();
		}
		this.url = url;
		
	}
	
	
	//Store the 2-d array in DataProvider
	@DataProvider(name="DP")
	public String[][] feedDP() throws BiffException, IOException
	{
		String data[][]= Utility.readExcel("inputdata1.xls", "sanity");
		return data;
	}
	
	//@Parameters({"expected","itemName"})
	 @BeforeMethod
	//public void verifyResultsPageTitle(String expected,String itemName)
	public void openUrl()
	{
		 
	   
		driver.get(url);
		driver.manage().window().maximize();
		hPage = new HomePage(driver);
		hPage.closePopUp();
		
	}
	//@Test(dataProvider="DP",description="Verifying the title in the Search Results page..")
	//public void verifyTitle( String itemName,String expectedItemCount )
	
	
	/*@Test(dataProvider="DP")
	public void verifyTitle(String itemName,String expectedItemCount)
	{
		//driver.get(url);
		//driver.manage().window().maximize();
		//hPage = new HomePage(driver);
		//hPage.closePopUp();
		
		sPage = hPage.enterSearchDetails(itemName);
	    boolean result = sPage.verifySearchResultsPageTile(itemName);
		Assert.assertTrue(result);
	}   */
		
		
	
	//@Test(dataProvider="DP",description="Verifying the itemName in the Search Results page..",dependsOnMethods="verifyTitle")
	@Test(dataProvider="DP")
	public void verifyItemsDescriptionCount( String itemName,String expectedItemCount)
	{
		sPage = hPage.enterSearchDetails(itemName);
	    boolean result = sPage.verifySearchResultsPageTile(itemName);
		Assert.assertTrue(result);
		
	    int actual = sPage.getItemsDescriptionCount(itemName);
	    System.out.println("actual number is  " +actual);
		int expected =Integer.parseInt(expectedItemCount);
		Assert.assertEquals(actual,expected);
		
		
	}
	@AfterClass
	public void closeBrowser()
	{
		driver.close();
	}
}