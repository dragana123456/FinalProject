package com.BrzeVesti.qa.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.BrzeVesti.qa.base.TestBase;
import com.BrzeVesti.qa.pages.DashboardPage;
import com.BrzeVesti.qa.pages.LoginPage;
import com.BrzeVesti.qa.pages.RegionsPage;
import com.BrzeVesti.qa.pages.RegionsPageInsertRegions;
import com.BrzeVesti.qa.util.Util;

public class RegionsPageTest extends TestBase{
	
	public RegionsPageTest(){
		super();
	}
	
	LoginPage loginPage;
	DashboardPage dashboardPage;
	RegionsPage regionsPage;
	RegionsPageInsertRegions regionsPageInsertRegions;
	
	@BeforeMethod
	public void setUp() {
		init();
		loginPage = new LoginPage();
		dashboardPage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		regionsPage = dashboardPage.clickOnRegionsLink();
	}
	
	@Test
	public void verifyRegionsPageLabel() {
		Assert.assertTrue(regionsPage.verifyRegionsPageLabel(), "RegionPageLabel label is missing on page ");
	}
	
	@Test
	public void addRegion() {
		regionsPageInsertRegions = regionsPage.clickOnAddRegions();
		String randomRegionName = Util.getRandomName();
		regionsPageInsertRegions.addNewRegion(randomRegionName);
		
		driver.findElement(By.xpath("//div[contains(text(),'Region \"" +  randomRegionName + "\" has been successfully saved!')]")).isDisplayed();
	}
	
	@Test
	public void deleteRegion() {
		regionsPageInsertRegions = regionsPage.clickOnAddRegions();
		String randomRegionName = Util.getRandomName();
		regionsPageInsertRegions.addNewRegion(randomRegionName);
		
		driver.findElement(By.xpath("//div[contains(text(),'Region \"" +  randomRegionName + "\" has been successfully saved!')]")).isDisplayed();
		
		regionsPage.deleteRegions(randomRegionName);
		driver.findElement(By.xpath("//button[contains(text(),'Delete')]")).click();
		
		
		driver.findElement(By.xpath("//div[contains(text(),'Region \"" +  randomRegionName + "\" has been successfully deleted!')]")).isDisplayed();

	}
	
	@AfterMethod
	public void tearDown(){
	driver.quit();
	}
}
