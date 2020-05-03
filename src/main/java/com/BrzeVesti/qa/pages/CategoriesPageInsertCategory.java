package com.BrzeVesti.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BrzeVesti.qa.base.TestBase;
import com.BrzeVesti.qa.util.Util;

public class CategoriesPageInsertCategory extends TestBase{
	
	public CategoriesPageInsertCategory() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[@id='save-category-button']")
	WebElement addBtn;
	
	@FindBy(xpath = "//input[@id='title']")
	WebElement categoryTitle;
	
	@FindBy(id="save-category-button")
	WebElement saveCategory;
	
	@FindBy(id="back-button")
	WebElement backToCategories;
	

	String randomCategoryName = Util.getRandomCategoryName();

	public void addNewCategory(String category) {
		categoryTitle.sendKeys(category);
		saveCategory.click();
	}
	
	public String insertRandomCategoryName() {
		String categoryName = Util.getRandomCategoryName(); 
		categoryTitle.sendKeys(categoryName);
		addBtn.click();
		return categoryName;
	}
	
	public CategoriesPage backToCategories() {
		backToCategories.click();
		return new CategoriesPage();
	}
	
	
	
}
