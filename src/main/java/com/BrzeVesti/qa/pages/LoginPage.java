package com.BrzeVesti.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BrzeVesti.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement loginBtn;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public DashboardPage login(String mail, String pwd) {
		email.sendKeys(mail);
		password.sendKeys(pwd);
		loginBtn.click();
		return new DashboardPage();
	}
}
