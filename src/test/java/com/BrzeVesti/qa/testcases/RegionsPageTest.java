package com.BrzeVesti.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.BrzeVesti.qa.base.TestBase;
import com.BrzeVesti.qa.pages.DashboardPage;
import com.BrzeVesti.qa.pages.LoginPage;
import com.BrzeVesti.qa.pages.RegionsPage;
import com.BrzeVesti.qa.pages.RegionsPageInsertRegions;

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
		regionsPage.clickOnAddRegions().addNewRegion("Mačva");
		
		Assert.assertEquals(regionsPage.successfullySaved(), true);
	}
	
	@Test
	public void deleteRegion() {
		regionsPage.clickOnAddRegions().addNewRegion("Mačva");
		regionsPage.deleteRegions("Mačva");
		
		Assert.assertEquals(regionsPage.successfullyDeleted(), true);
	}
	
	@Test
	public void addRandomRegion() {
		regionsPage.clickOnAddRegions().insertRandomRegion();
		
		Assert.assertTrue(regionsPage.successfullySaved(), "Region not added!!");
	}
	
	@Test
	public void deleteRandomRegion() {
		String regionName = regionsPage.clickOnAddRegions().insertRandomRegion();
		regionsPage.deleteRegions(regionName);
		
		Assert.assertTrue(regionsPage.successfullyDeleted(), "Region not deleted");	
	}
	
	@AfterMethod
	public void tearDown(){
	driver.quit();
	}
}
