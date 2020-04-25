package com.BrzeVesti.qa.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.BrzeVesti.qa.base.TestBase;
import com.BrzeVesti.qa.pages.CategoriesPage;
import com.BrzeVesti.qa.pages.CategoriesPageInsertCategory;
import com.BrzeVesti.qa.pages.DashboardPage;
import com.BrzeVesti.qa.pages.LoginPage;
import com.BrzeVesti.qa.util.Util;

public class CategoriesPageTests extends TestBase{
	
	public CategoriesPageTests() {
		super();
	}
	
	LoginPage loginPage;
	DashboardPage dashboardPage;
	CategoriesPage categoriesPage;
	CategoriesPageInsertCategory categoriesPageInsertCategory;
	
	@BeforeMethod
	public void setUp() {
		init();
		loginPage = new LoginPage();
		dashboardPage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		categoriesPage = dashboardPage.clickOnCategoriesLink();
	}
	
	@Test
	public void verifyCategoriesPageLabel() {
		Assert.assertTrue(categoriesPage.verifyContactPageLabel(), "ContactsPageLabel label is missing on page");
	}
	
    //Testing Add category button
	
	@Test
	public String addCategory() {
		categoriesPageInsertCategory = categoriesPage.clickOnAddCategory();
		String randomCategoryName = Util.getRandomName();
		categoriesPageInsertCategory.addNewCategory(randomCategoryName);
		
		driver.findElement(By.xpath("//div[contains(text(),'Category \"" +  randomCategoryName + "\" has been successfully saved!')]")).isDisplayed();
		return randomCategoryName;
	}
	
    //Testing Delete Category button (add random category, delete that random category)
	
	@Test
	public void deleteCategory() {
		String randomCategoryName = this.addCategory();
		
		categoriesPage.deleteCategories(randomCategoryName);
		driver.findElement(By.xpath("//button[contains(text(),'Delete')]")).click();
		
		driver.findElement(By.xpath("//div[contains(text(),'Category \"" +  randomCategoryName + "\" has been successfully deleted!')]")).isDisplayed();
	}
	
	@Test
	public void backToCategory() {
		
		categoriesPageInsertCategory = categoriesPage.clickOnAddCategory();
		categoriesPageInsertCategory.backToCategories();	
	}
	
	@AfterMethod
	public void tearDown(){
	driver.quit();
	}
	
}
