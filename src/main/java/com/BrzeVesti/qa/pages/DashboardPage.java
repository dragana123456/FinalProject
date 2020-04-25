package com.BrzeVesti.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BrzeVesti.qa.base.TestBase;

public class DashboardPage extends TestBase{
	
	@FindBy(xpath="//a[contains(text(),'Signatures')]")
	WebElement signatures;
	
	@FindBy(xpath="//a[contains(text(),'Categories')]")
	WebElement categories;
	
	@FindBy(xpath="//a[contains(text(),'Regions')]")
	WebElement regions;
	
	@FindBy(xpath="//a[contains(text(),'Portals')]")
	WebElement portals;
	
	@FindBy(xpath="//a[contains(text(),'Sources')]")
	WebElement sources;
	
	
	public DashboardPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyDashboardPageTitle() {
		return driver.getTitle();
	}
	
	public SignaturesPage clickOnSignaturesLink() {
		signatures.click();
		return new SignaturesPage();
	}
	
	public CategoriesPage clickOnCategoriesLink() {
		categories.click();
		return new CategoriesPage();
	}
	
	public RegionsPage clickOnRegionsLink() {
		regions.click();
		return new RegionsPage();
	}
	
	
	
	public SourcesPage clickOnSourcesLink() {
		sources.click();
		return new SourcesPage();
	}
	
	
	
	
	
	
	

}
