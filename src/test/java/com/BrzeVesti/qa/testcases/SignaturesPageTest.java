package com.BrzeVesti.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.BrzeVesti.qa.base.TestBase;
import com.BrzeVesti.qa.pages.DashboardPage;
import com.BrzeVesti.qa.pages.LoginPage;
import com.BrzeVesti.qa.pages.SignaturesPage;

public class SignaturesPageTest extends TestBase{
	
	public SignaturesPageTest() {
		super();
	}
	
	LoginPage loginPage;
	DashboardPage dashboardPage;
	SignaturesPage signaturesPage;
	
	@BeforeMethod
	public void setUp() {
		init();
		loginPage = new LoginPage();
		dashboardPage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		signaturesPage = dashboardPage.clickOnSignaturesLink();
	}
	
	@Test
	public void verifySignaturesPageLabel() {
		Assert.assertTrue(signaturesPage.verifySignaturesLabel(), "Signatures label is missing on page");
	}
	
	@Test
	public void selectSignaturesByValueTest() {
		signaturesPage.selectSignaturesByValues("kurir", "New", "Film");
	}
	
	@AfterMethod
	public void tearDown(){
	driver.quit();
	}
	

}
