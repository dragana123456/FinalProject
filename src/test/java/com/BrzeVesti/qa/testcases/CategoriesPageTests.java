package com.BrzeVesti.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.BrzeVesti.qa.base.TestBase;
import com.BrzeVesti.qa.pages.CategoriesPage;
import com.BrzeVesti.qa.pages.CategoriesPageInsertCategory;
import com.BrzeVesti.qa.pages.DashboardPage;
import com.BrzeVesti.qa.pages.LoginPage;

public class CategoriesPageTests extends TestBase{
	
	private CategoriesPage categoriesPage;
	private CategoriesPageInsertCategory categoriesPageInsertCategory;
	
	@BeforeMethod
	public void setUp() {
		init();
		LoginPage loginPage = new LoginPage();
		DashboardPage dashboardPage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		categoriesPage = dashboardPage.clickOnCategoriesLink();
	}
	
	@Test
	public void verifyCategoriesPageLabel() {
		Assert.assertTrue(categoriesPage.verifyContactPageLabel(), "ContactsPageLabel label is missing on page");
	}
	
    //Testing Add category button
	
	@Ignore
	public void addCategory() {
		categoriesPage.clickOnAddCategory().addNewCategory("Dragana");
		Assert.assertEquals(categoriesPage.successfullySaved(), true);
	}
	
	@Test
	public void addRandomCategory() {
		categoriesPage.clickOnAddCategory().insertRandomCategoryName();
		
		Assert.assertEquals(categoriesPage.successfullySaved(), true);
	}
		
	@Test
	public void deleteCategory() {
		categoriesPage.clickOnAddCategory().addNewCategory("Dragana");
		categoriesPage.deleteCategory("Dragana");
		
		Assert.assertTrue(categoriesPage.successfullyDeleted());	
	}
	
	@Test
	public void deleteRandomCategory() {
		String categoryName = categoriesPage.clickOnAddCategory().insertRandomCategoryName();
		categoriesPage.deleteCategory(categoryName);	
		
		Assert.assertTrue(categoriesPage.successfullyDeleted());	
	}
	
	@Test
	public void backToCategory() {
		
		categoriesPageInsertCategory = categoriesPage.clickOnAddCategory();
		categoriesPageInsertCategory.backToCategories();
		
		Assert.assertTrue(categoriesPage.verifyContactPageLabel());
	}
	
	@AfterMethod
	public void tearDown(){
	driver.quit();
	}
	
}
