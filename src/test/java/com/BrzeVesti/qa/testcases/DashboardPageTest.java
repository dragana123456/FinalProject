package com.BrzeVesti.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.BrzeVesti.qa.base.TestBase;
import com.BrzeVesti.qa.pages.CategoriesPage;
import com.BrzeVesti.qa.pages.DashboardPage;
import com.BrzeVesti.qa.pages.LoginPage;
import com.BrzeVesti.qa.pages.RegionsPage;
import com.BrzeVesti.qa.pages.SignaturesPage;
import com.BrzeVesti.qa.pages.SourcesPage;

public class DashboardPageTest extends TestBase{
	LoginPage loginPage;
	DashboardPage dashboardPage;
	SignaturesPage signaturesPage;
	CategoriesPage categoriesPage;
	RegionsPage regionsPage;
	SourcesPage sourcesPage;
	
	public DashboardPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		init();
		loginPage = new LoginPage();
		dashboardPage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
	}
	
	@Test
	public void verifyDashboardPageTitleTest() {
		
			String dashbardPageTitle = dashboardPage.verifyDashboardPageTitle();
			Assert.assertEquals(dashbardPageTitle, "Brze vesti admin", "Home page title not matched.");
	}
	
	@Test
	public void veritySignaturesLinkTest() {
		signaturesPage = dashboardPage.clickOnSignaturesLink();
	}
	
	@Test
	public void verityCategoriesLinkTest() {
		categoriesPage = dashboardPage.clickOnCategoriesLink();
	}
	
	@Test
	public void verityRegionsLinkTest() {
		regionsPage = dashboardPage.clickOnRegionsLink();
	}
	
	@Test
	public void veritySourcesLinkTest() {
		sourcesPage = dashboardPage.clickOnSourcesLink();
	}
	
	@AfterMethod

	public void tearDown() {
	driver.quit();
	}

}
