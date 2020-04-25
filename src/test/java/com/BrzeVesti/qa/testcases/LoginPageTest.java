package com.BrzeVesti.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.BrzeVesti.qa.base.TestBase;
import com.BrzeVesti.qa.pages.DashboardPage;
import com.BrzeVesti.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;
	DashboardPage dashboardPage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		init();
		loginPage = new LoginPage();
		
	}
	
	@Test
	public void loginTest() {
		dashboardPage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
	driver.quit();
	}
	

}
