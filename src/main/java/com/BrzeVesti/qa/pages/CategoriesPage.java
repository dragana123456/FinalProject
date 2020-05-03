package com.BrzeVesti.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
	
	@FindBy(xpath = "//div[contains(text(),'successfully saved!')]")
	WebElement successfullySaved;
	
	@FindBy(xpath = "//div[contains(text(),'successfully deleted!')]")
	WebElement successfullyDeleted;
	
				
	public boolean verifyContactPageLabel() {
		return contactsLabel.isDisplayed();
	}
	
	public CategoriesPageInsertCategory clickOnAddCategory() {
		addBtn.click();
		return new CategoriesPageInsertCategory();
	}
	
	public void deleteCategory(String categoryName) {
		driver.findElement(By.xpath("//button[@data-category_title='" + categoryName + "' and @title='Delete']")).click();
		wait.until(ExpectedConditions.visibilityOf(delete)).click();
	}
	
	public boolean successfullySaved() {
		return successfullySaved.isDisplayed();
	}
	
	public boolean successfullyDeleted() {
		return successfullyDeleted.isDisplayed();
	}
	
}
