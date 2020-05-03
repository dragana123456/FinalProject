package com.BrzeVesti.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BrzeVesti.qa.base.TestBase;

public class RegionsPage extends TestBase {
	
	RegionsPageInsertRegions regionsPageInsertRegions;
	
	public RegionsPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[contains(text(),'Regions')]")
	WebElement regionLabel;
	
	@FindBy(xpath = "//a[@type]")
	WebElement addBtn;

	@FindBy(xpath = "//button[contains(text(),'Delete')]")
	WebElement delete;
	
	@FindBy(xpath="//div[contains(text(),'successfully saved!')]")
	WebElement successfullySaved;
	
	public boolean verifyRegionsPageLabel() {
		return regionLabel.isDisplayed();
	}
	
	public RegionsPageInsertRegions clickOnAddRegions() {
		addBtn.click();
		return new RegionsPageInsertRegions();
	}
	
	public void deleteRegions(String regionName) {
		driver.findElement(By.xpath("//button[@data-region_title=\"" + regionName + "\" and @title=\"Delete\"]")).click();
		delete.click();	
	}
	
	public boolean successfullySaved() {
		return successfullySaved.isDisplayed();
	}
	
	public boolean successfullyDeleted() {
		return delete.isDisplayed();
	}
}
