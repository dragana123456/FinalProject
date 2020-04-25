package com.BrzeVesti.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BrzeVesti.qa.base.TestBase;

public class RegionsPageInsertRegions extends TestBase{
	
	public RegionsPageInsertRegions() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@id='title']")
	WebElement regionTitle;
	
	@FindBy(xpath = "//button[@id='save-region-button']")
	WebElement saveRegion;
	
	@FindBy(id="back-button")
	WebElement backToRegion;
	
	public void addNewRegion(String region) {
		regionTitle.sendKeys(region);
		saveRegion.click();
	}
	
	public CategoriesPage backToCategories() {
		backToRegion.click();
		return new CategoriesPage();
	}

}
