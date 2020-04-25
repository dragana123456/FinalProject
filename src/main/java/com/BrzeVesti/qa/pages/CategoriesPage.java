package com.BrzeVesti.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BrzeVesti.qa.base.TestBase;

public class CategoriesPage extends TestBase {
	
	CategoriesPageInsertCategory cateogriesPageInsertCategory;
	
	public CategoriesPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[contains(text(),'Categories')]")
	WebElement contactsLabel;
	
	@FindBy(xpath = "//a[@type='button']")
	WebElement addBtn;
	
	@FindBy(xpath = "//button[contains(text(),'Delete')]")
	WebElement delete;
	
	@FindBy(id="categoriesTable")
	WebElement allFromCategories;
			
	public boolean verifyContactPageLabel() {
		return contactsLabel.isDisplayed();
	}
	
	public CategoriesPageInsertCategory clickOnAddCategory() {
		addBtn.click();
		return new CategoriesPageInsertCategory();
	}
	
	public void deleteCategories(String categoryName) {
		driver.findElement(By.xpath("//button[@data-category_title='" + categoryName + "' and @title='Delete']")).click();
		delete.click();	
	}
}
