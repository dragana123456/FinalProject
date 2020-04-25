package com.BrzeVesti.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.BrzeVesti.qa.base.TestBase;

public class SignaturesPage extends TestBase{
	
	@FindBy(xpath = "//div[contains(text(),'Signatures')]")
	WebElement signaturesLabel;
	
	@FindBy(id = "newsProcessorSignaturePortalSelect")
	WebElement selectPortals;
	
	@FindBy(id = "newsProcessorSignatureStatusSelect")
	WebElement selectSignatureStatus;
	
	@FindBy(id="newsProcessorSignatureCategorySelect")
	WebElement selectCategory;
	
	public SignaturesPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifySignaturesLabel() {
		return signaturesLabel.isDisplayed();
	}
	
	public void selectFromPortalsFilter(String portalsName){
        Select portalsDropdown = new Select(selectPortals);
        portalsDropdown.selectByVisibleText(portalsName);
    }
	
	public void selectFromSignatureStatus(String status){
        Select signatureDropdown = new Select(selectSignatureStatus);
        signatureDropdown.selectByVisibleText(status);
    }
	
	public void selectFromCategory(String category){
        Select signatureDropdown = new Select(selectCategory);
        signatureDropdown.selectByVisibleText(category);
    }
	
	
	public void selectSignaturesByValues(String portal, String status, String category) {
		selectFromPortalsFilter(portal);
		selectFromSignatureStatus(status);
		selectFromCategory(category);
	}

}
